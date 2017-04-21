package com.markettime.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.markettime.context.UserContext;
import com.markettime.model.entity.UserEntity;
import com.markettime.model.entity.UserSessionEntity;
import com.markettime.repository.UserSessionRepository;
import com.markettime.service.model.Menu;
import com.markettime.service.model.MenuItem;
import com.markettime.util.Constants;
import com.markettime.util.DateUtil;

/**
 *
 * @author Radu Cosma
 *
 */
@Service
@Transactional
public class UserContextService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserContextService.class);

    private static final String UUID_COOKIE_NAME = "uuid";

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private UserContext userContext;

    @Autowired
    private UserSessionRepository userSessionRepository;

    /**
     *
     * @param request
     */
    public void initializeUserContext(HttpServletRequest request) {
        processCookies(request.getCookies());
        createMenu(getRequestPath(request));
    }

    private void processCookies(Cookie[] cookies) {
        if (cookies != null) {
            Arrays.stream(cookies).filter(cookie -> UUID_COOKIE_NAME.equals(cookie.getName()))
                    .forEach(this::processUuidCookie);
        }
    }

    private void processUuidCookie(Cookie cookie) {
        String uuid = cookie.getValue();
        UserSessionEntity userSessionEntity = userSessionRepository.findActive(uuid);
        Date currentDate = DateUtil.getCurrentDate();
        if (userSessionEntity != null) {
            if (isSessionValid(userSessionEntity, currentDate)) {
                UserEntity userEntity = userSessionEntity.getUser();
                renewUserSession(userSessionEntity, currentDate);
                updateCookie(cookie, cookie.getValue(), cookie.getPath(), Constants.SESSION_LIFETIME_SECONDS);
                userContext.setUserId(userEntity.getId());
                userContext.setLoggedIn(Boolean.TRUE);
                userContext.setEmail(userEntity.getEmail());
            } else {
                LOGGER.debug("Invalid session: lastAccess={}, currentTime={}", userSessionEntity.getLastAccess(),
                        currentDate);
                userSessionEntity.setActive(Boolean.FALSE);
                updateCookie(cookie, "", "/", 0);
            }
        } else {
            updateCookie(cookie, "", "/", 0);
        }
    }

    private boolean isSessionValid(UserSessionEntity userSessionEntity, Date currentDate) {
        return currentDate.getTime() - userSessionEntity.getLastAccess().getTime() < Constants.SESSION_LIFETIME_MILLIS;
    }

    private void renewUserSession(UserSessionEntity userSessionEntity, Date currentDate) {
        userSessionEntity.setLastAccess(currentDate);
    }

    private void updateCookie(Cookie cookie, String value, String path, int maxAge) {
        cookie.setMaxAge(maxAge);
        cookie.setValue(value);
        cookie.setPath(path);
        response.addCookie(cookie);
    }

    private String getRequestPath(HttpServletRequest request) {
        String requestPath = request.getContextPath().concat(request.getServletPath());
        if (!StringUtils.isEmpty(request.getQueryString())) {
            requestPath = requestPath.concat("?").concat(request.getQueryString());
        }
        return requestPath;
    }

    private void createMenu(String requestPath) {
        Menu menu = new Menu();
        menu.add(new MenuItem("MENU.DASHBOARD", "/market-time/dashboard", "fa-dashboard", null));
        menu.add(new MenuItem("MENU.ADD.PRODUCT", "/market-time/products/add", "fa-edit", null));
        menu.add(new MenuItem("MENU.PRODUCTS.LIST", "/market-time/#", "fa-table", createProductsSubMenu()));
        menu.add(new MenuItem("MENU.ORDERS", "/market-time/orders", "fa-money", null));
        menu.add(new MenuItem("MENU.MESSAGES", "/market-time/messages", "fa-envelope-o", null));
        menu.add(new MenuItem("MENU.CALENDAR.EVENTS", "/market-time/calendarEvents", "fa-calendar", null));
        menu.add(new MenuItem("MENU.SETTINGS", "/market-time/settings", "fa-cog", null));
        menu.add(new MenuItem("MENU.INVOICES", "/market-time/invoices", "fa-money", null));
        menu.add(new MenuItem("MENU.MY.PROFILE", "/market-time/profile", "fa-user", null));
        menu.add(new MenuItem("MENU.ABOUT.US", "/market-time/aboutUs", "fa-info-circle", null));

        setSelectedItem(menu.getMenuItems(), requestPath);

        userContext.setMenu(menu);
    }

    private List<MenuItem> createProductsSubMenu() {
        List<MenuItem> productsSubMenu = new ArrayList<>(2);
        productsSubMenu.add(
                new MenuItem("MENU.PUBLISHED.PRODUCTS", "/market-time/products?status=published", "fa-circle-o", null));
        productsSubMenu.add(new MenuItem("MENU.UNPUBLISHED.PRODUCTS", "/market-time/products?status=unpublished",
                "fa-circle-o", null));
        return productsSubMenu;
    }

    private boolean setSelectedItem(List<MenuItem> menuItems, String requestPath) {
        boolean foundActive = Boolean.FALSE;
        for (MenuItem menuItem : menuItems) {
            List<MenuItem> subMenuItems = menuItem.getSubMenuItems();
            if (subMenuItems != null && !subMenuItems.isEmpty()) {
                foundActive = setSelectedItem(subMenuItems, requestPath);
            }
            if (foundActive || requestPath.equals(menuItem.getUrl())) {
                menuItem.setActive(Boolean.TRUE);
                return Boolean.TRUE;
            }
        }
        return foundActive;
    }

}
