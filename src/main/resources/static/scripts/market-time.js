/*! MarketTime app.js
 * ================
 */

//Make sure jQuery has been loaded before app.js
if (typeof jQuery === "undefined") {
    throw new Error("MarketTime requires jQuery");
}

/* MarketTime
 *
 * @type Object
 * @description $.MarketTime is the main object for the template's app.
 *              It's used for implementing functions and options related
 *              to the template. Keeping everything wrapped in an object
 *              prevents conflict with other plugins and is a better
 *              way to organize our code.
 */
$.MarketTime = {};

/* --------------------
 * - MarketTime Options -
 * --------------------
 * Modify these options to suit your implementation
 */
$.MarketTime.options = {
    //Add slimscroll to navbar menus
    //This requires you to load the slimscroll plugin
    //in every page before app.js
    navbarMenuSlimscroll : true,
    navbarMenuSlimscrollWidth : "3px", //The width of the scroll bar
    navbarMenuHeight : "200px", //The height of the inner menu
    //General animation speed for JS animated elements such as box collapse/expand and
    //sidebar treeview slide up/down. This options accepts an integer as milliseconds,
    //'fast', 'normal', or 'slow'
    animationSpeed : 500,
    //Sidebar push menu toggle button selector
    sidebarToggleSelector : "[data-toggle='offcanvas']",
    //Activate sidebar push menu
    sidebarPushMenu : true,
    //Activate sidebar slimscroll if the fixed layout is set (requires SlimScroll Plugin)
    sidebarSlimScroll : true,
    //Enable sidebar expand on hover effect for sidebar mini
    //This option is forced to true if both the fixed layout and sidebar mini
    //are used together
    sidebarExpandOnHover : false,
    //BoxRefresh Plugin
    enableBoxRefresh : true,
    //Bootstrap.js tooltip
    enableBSToppltip : true,
    BSTooltipSelector : "[data-toggle='tooltip']",
    //Enable Fast Click. Fastclick.js creates a more
    //native touch experience with touch devices. If you
    //choose to enable the plugin, make sure you load the script
    //before AdminLTE's app.js
    enableFastclick : true,
    //Control Sidebar Options
    enableControlSidebar : true,
    controlSidebarOptions : {
        //Which button should trigger the open/close event
        toggleBtnSelector : "[data-toggle='control-sidebar']",
        //The sidebar selector
        selector : ".control-sidebar",
        //Enable slide over content
        slide : true
    },
    //Box Widget Plugin. Enable this plugin
    //to allow boxes to be collapsed and/or removed
    enableBoxWidget : true,
    //Box Widget plugin options
    boxWidgetOptions : {
        boxWidgetIcons : {
            //Collapse icon
            collapse : 'fa-minus',
            //Open icon
            open : 'fa-plus',
            //Remove icon
            remove : 'fa-times'
        },
        boxWidgetSelectors : {
            //Remove button selector
            remove : '[data-widget="remove"]',
            //Collapse button selector
            collapse : '[data-widget="collapse"]'
        }
    },
    //Define the set of colors to use globally around the website
    colors : {
        red : "#f56954",
        green : "#00a65a",
        aqua : "#00c0ef",
        yellow : "#f39c12",
        blue : "#0073b7",
        navy : "#001F3F",
        orange : "#FF851B",
        black : "#222222",
        gray : "#d2d6de"
    },
    //The standard screen sizes that bootstrap uses.
    //If you change these in the variables.less file, change
    //them here too.
    screenSizes : {
        xs : 480,
        sm : 768,
        md : 992,
        lg : 1200
    }
};

/* ------------------
 * - Implementation -
 * ------------------
 * The next block of code implements MarketTime's
 * functions and plugins as specified by the
 * options above.
 */
$(function() {
    "use strict";

    //Fix for IE page transitions
    $("body").removeClass("hold-transition");

    //Extend options if external options exist
    if (typeof MarketTimeOptions !== "undefined") {
        $.extend(true, $.MarketTime.options, MarketTimeOptions);
    }

    //Easy access to options
    var o = $.MarketTime.options;

    //Set up the object
    _init();

    //Activate the layout maker
    $.MarketTime.layout.activate();

    //Enable sidebar tree view controls
    $.MarketTime.tree('.sidebar');

    //Enable control sidebar
    if (o.enableControlSidebar) {
        $.MarketTime.controlSidebar.activate();
    }

    //Add slimscroll to navbar dropdown
    if (o.navbarMenuSlimscroll && typeof $.fn.slimscroll != 'undefined') {
        $(".navbar .menu").slimscroll({
            height : o.navbarMenuHeight,
            alwaysVisible : false,
            size : o.navbarMenuSlimscrollWidth
        }).css("width", "100%");
    }

    //Activate sidebar push menu
    if (o.sidebarPushMenu) {
        $.MarketTime.pushMenu.activate(o.sidebarToggleSelector);
    }

    //Activate Bootstrap tooltip
    if (o.enableBSToppltip) {
        $('body').tooltip({
            selector : o.BSTooltipSelector
        });
    }

    //Activate box widget
    if (o.enableBoxWidget) {
        $.MarketTime.boxWidget.activate();
    }

    //Activate fast click
    if (o.enableFastclick && typeof FastClick != 'undefined') {
        FastClick.attach(document.body);
    }

    /*
     * INITIALIZE BUTTON TOGGLE
     * ------------------------
     */
    $('.btn-group[data-toggle="btn-toggle"]').each(function() {
        var group = $(this);
        $(this).find(".btn").on('click', function(e) {
            group.find(".btn.active").removeClass("active");
            $(this).addClass("active");
            e.preventDefault();
        });

    });
});

/* ----------------------------------
 * - Initialize the MarketTime Object -
 * ----------------------------------
 * All MarketTime functions are implemented below.
 */
function _init() {
    'use strict';
    /* Layout
     * ======
     * Fixes the layout height in case min-height fails.
     *
     * @type Object
     * @usage $.MarketTime.layout.activate()
     *        $.MarketTime.layout.fix()
     *        $.MarketTime.layout.fixSidebar()
     */
    $.MarketTime.layout = {
        activate : function() {
            var _this = this;
            _this.fix();
            _this.fixSidebar();
            $(window, ".wrapper").resize(function() {
                _this.fix();
                _this.fixSidebar();
            });
        },
        fix : function() {
            //Get window height and the wrapper height
            var neg = $('#header-container').outerHeight()
                    + $('#footer-container').outerHeight();
            var window_height = $(window).height();
            var sidebar_height = $(".sidebar").height();
            //Set the min-height of the content and sidebar based on the
            //the height of the document.
            if ($("body").hasClass("fixed")) {
                $("#main-container, .right-side").css('min-height',
                        window_height - $('#footer-container').outerHeight());
            } else {
                var postSetWidth;
                if (window_height >= sidebar_height) {
                    $("#main-container, .right-side").css('min-height',
                            window_height - neg);
                    postSetWidth = window_height - neg;
                } else {
                    $("#main-container, .right-side").css('min-height',
                            sidebar_height);
                    postSetWidth = sidebar_height;
                }

                //Fix for the control sidebar height
                var controlSidebar = $($.MarketTime.options.controlSidebarOptions.selector);
                if (typeof controlSidebar !== "undefined") {
                    if (controlSidebar.height() > postSetWidth)
                        $("#main-container, .right-side").css('min-height',
                                controlSidebar.height());
                }

            }
        },
        fixSidebar : function() {
            //Make sure the body tag has the .fixed class
            if (!$("body").hasClass("fixed")) {
                if (typeof $.fn.slimScroll != 'undefined') {
                    $(".sidebar").slimScroll({
                        destroy : true
                    }).height("auto");
                }
                return;
            } else if (typeof $.fn.slimScroll == 'undefined' && window.console) {
                window.console
                        .error("Error: the fixed layout requires the slimscroll plugin!");
            }
            //Enable slimscroll for fixed layout
            if ($.MarketTime.options.sidebarSlimScroll) {
                if (typeof $.fn.slimScroll != 'undefined') {
                    //Destroy if it exists
                    $(".sidebar").slimScroll({
                        destroy : true
                    }).height("auto");
                    //Add slimscroll
                    $(".sidebar").slimscroll(
                            {
                                height : ($(window).height() - $(
                                        "#header-container").height())
                                        + "px",
                                color : "rgba(0,0,0,0.2)",
                                size : "3px"
                            });
                }
            }
        }
    };

    /* PushMenu()
     * ==========
     * Adds the push menu functionality to the sidebar.
     *
     * @type Function
     * @usage: $.MarketTime.pushMenu("[data-toggle='offcanvas']")
     */
    $.MarketTime.pushMenu = {
        activate : function(toggleBtn) {
            //Get the screen sizes
            var screenSizes = $.MarketTime.options.screenSizes;

            //Enable sidebar toggle
            $(toggleBtn).on(
                    'click',
                    function(e) {
                        e.preventDefault();

                        //Enable sidebar push menu
                        if ($(window).width() > (screenSizes.sm - 1)) {
                            if ($("body").hasClass('sidebar-collapse')) {
                                $("body").removeClass("sidebar-mini");
                                $("body").removeClass('sidebar-collapse')
                                        .trigger('expanded.pushMenu');
                            } else {
                                $("body").addClass("sidebar-mini");
                                $("body").addClass('sidebar-collapse').trigger(
                                        'collapsed.pushMenu');
                            }
                        }
                        //Handle sidebar push menu for small screens
                        else {
                            if ($("body").hasClass('sidebar-open')) {
                                $("body").removeClass('sidebar-open')
                                        .removeClass('sidebar-collapse')
                                        .trigger('collapsed.pushMenu');
                            } else {
                                $("body").addClass('sidebar-open').trigger(
                                        'expanded.pushMenu');
                            }
                        }
                    });

            $("#main-container").click(
                    function() {
                        //Enable hide menu when clicking on the content-wrapper on small screens
                        if ($(window).width() <= (screenSizes.sm - 1)
                                && $("body").hasClass("sidebar-open")) {
                            $("body").removeClass('sidebar-open');
                        }
                    });

            //Enable expand on hover for sidebar mini
            if ($.MarketTime.options.sidebarExpandOnHover
                    || ($('body').hasClass('fixed') && $('body').hasClass(
                            'sidebar-mini'))) {
                this.expandOnHover();
            }
        },
        expandOnHover : function() {
            var _this = this;
            var screenWidth = $.MarketTime.options.screenSizes.sm - 1;
            //Expand sidebar on hover
            $('#menu-container').hover(
                    function() {
                        if ($('body').hasClass('sidebar-mini')
                                && $("body").hasClass('sidebar-collapse')
                                && $(window).width() > screenWidth) {
                            _this.expand();
                        }
                    },
                    function() {
                        if ($('body').hasClass('sidebar-mini')
                                && $('body').hasClass(
                                        'sidebar-expanded-on-hover')
                                && $(window).width() > screenWidth) {
                            _this.collapse();
                        }
                    });
        },
        expand : function() {
            $("body").removeClass('sidebar-collapse').addClass(
                    'sidebar-expanded-on-hover');
        },
        collapse : function() {
            if ($('body').hasClass('sidebar-expanded-on-hover')) {
                $('body').removeClass('sidebar-expanded-on-hover').addClass(
                        'sidebar-collapse');
            }
        }
    };

    /* Tree()
     * ======
     * Converts the sidebar into a multilevel
     * tree view menu.
     *
     * @type Function
     * @Usage: $.MarketTime.tree('.sidebar')
     */
    $.MarketTime.tree = function(menu) {
        var _this = this;
        var animationSpeed = $.MarketTime.options.animationSpeed;
        $(document).on(
                'click',
                menu + ' li a',
                function(e) {
                    //Get the clicked link and the next element
                    var $this = $(this);
                    var checkElement = $this.next();

                    //Check if the next element is a menu and is visible
                    if ((checkElement.is('.treeview-menu'))
                            && (checkElement.is(':visible'))) {
                        //Close the menu
                        checkElement.slideUp(animationSpeed, function() {
                            checkElement.removeClass('menu-open');
                            //Fix the layout in case the sidebar stretches over the height of the window
                            //_this.layout.fix();
                        });
                        checkElement.parent("li").removeClass("active");
                    }
                    //If the menu is not visible
                    else if ((checkElement.is('.treeview-menu'))
                            && (!checkElement.is(':visible'))) {
                        //Get the parent menu
                        var parent = $this.parents('ul').first();
                        //Close all open menus within the parent
                        var ul = parent.find('ul:visible').slideUp(
                                animationSpeed);
                        //Remove the menu-open class from the parent
                        ul.removeClass('menu-open');
                        //Get the parent li
                        var parent_li = $this.parent("li");

                        //Open the target menu and add the menu-open class
                        checkElement.slideDown(animationSpeed, function() {
                            //Add the class active to the parent li
                            checkElement.addClass('menu-open');
                            parent.find('li.active').removeClass('active');
                            parent_li.addClass('active');
                            //Fix the layout in case the sidebar stretches over the height of the window
                            _this.layout.fix();
                        });
                    }
                    //if this isn't a link, prevent the page from being redirected
                    if (checkElement.is('.treeview-menu')) {
                        e.preventDefault();
                    }
                });
    };

    /* ControlSidebar
     * ==============
     * Adds functionality to the right sidebar
     *
     * @type Object
     * @usage $.AdminLTE.controlSidebar.activate(options)
     */
    $.MarketTime.controlSidebar = {
        //instantiate the object
        activate : function() {
            //Get the object
            var _this = this;
            //Update options
            var o = $.MarketTime.options.controlSidebarOptions;
            //Get the sidebar
            var sidebar = $(o.selector);
            //The toggle button
            var btn = $(o.toggleBtnSelector);

            //Listen to the click event
            btn.on('click', function(e) {
                e.preventDefault();
                //If the sidebar is not open
                if (!sidebar.hasClass('control-sidebar-open')
                        && !$('body').hasClass('control-sidebar-open')) {
                    //Open the sidebar
                    _this.open(sidebar, o.slide);
                } else {
                    _this.close(sidebar, o.slide);
                }
            });

            //If the body has a boxed layout, fix the sidebar bg position
            var bg = $(".control-sidebar-bg");
            _this._fix(bg);

            //If the body has a fixed layout, make the control sidebar fixed
            if ($('body').hasClass('fixed')) {
                _this._fixForFixed(sidebar);
            } else {
                //If the content height is less than the sidebar's height, force max height
                if ($('#main-container, .right-side').height() < sidebar
                        .height()) {
                    _this._fixForContent(sidebar);
                }
            }
        },
        //Open the control sidebar
        open : function(sidebar, slide) {
            //Slide over content
            if (slide) {
                sidebar.addClass('control-sidebar-open');
            } else {
                //Push the content by adding the open class to the body instead
                //of the sidebar itself
                $('body').addClass('control-sidebar-open');
            }
        },
        //Close the control sidebar
        close : function(sidebar, slide) {
            if (slide) {
                sidebar.removeClass('control-sidebar-open');
            } else {
                $('body').removeClass('control-sidebar-open');
            }
        },
        _fix : function(sidebar) {
            var _this = this;
            if ($("body").hasClass('layout-boxed')) {
                sidebar.css('position', 'absolute');
                sidebar.height($(".wrapper").height());
                $(window).resize(function() {
                    _this._fix(sidebar);
                });
            } else {
                sidebar.css({
                    'position' : 'fixed',
                    'height' : 'auto'
                });
            }
        },
        _fixForFixed : function(sidebar) {
            sidebar.css({
                'position' : 'fixed',
                'max-height' : '100%',
                'overflow' : 'auto',
                'padding-bottom' : '50px'
            });
        },
        _fixForContent : function(sidebar) {
            $("#main-container, .right-side").css('min-height',
                    sidebar.height());
        }
    };

    /* BoxWidget
     * =========
     * BoxWidget is a plugin to handle collapsing and
     * removing boxes from the screen.
     *
     * @type Object
     * @usage $.AdminLTE.boxWidget.activate()
     *        Set all your options in the main $.AdminLTE.options object
     */
    $.MarketTime.boxWidget = {
        selectors : $.MarketTime.options.boxWidgetOptions.boxWidgetSelectors,
        icons : $.MarketTime.options.boxWidgetOptions.boxWidgetIcons,
        animationSpeed : $.MarketTime.options.animationSpeed,
        activate : function(_box) {
            var _this = this;
            if (!_box) {
                _box = document; // activate all boxes per default
            }
            //Listen for collapse event triggers
            $(_box).on('click', _this.selectors.collapse, function(e) {
                e.preventDefault();
                _this.collapse($(this));
            });

            //Listen for remove event triggers
            $(_box).on('click', _this.selectors.remove, function(e) {
                e.preventDefault();
                _this.remove($(this));
            });
        },
        collapse : function(element) {
            var _this = this;
            //Find the box parent
            var box = element.parents(".box").first();
            //Find the body and the footer
            var box_content = box
                    .find("> .box-body, > .box-footer, > form  >.box-body, > form > .box-footer");
            if (!box.hasClass("collapsed-box")) {
                //Convert minus into plus
                element.children(":first").removeClass(_this.icons.collapse)
                        .addClass(_this.icons.open);
                //Hide the content
                box_content.slideUp(_this.animationSpeed, function() {
                    box.addClass("collapsed-box");
                });
            } else {
                //Convert plus into minus
                element.children(":first").removeClass(_this.icons.open)
                        .addClass(_this.icons.collapse);
                //Show the content
                box_content.slideDown(_this.animationSpeed, function() {
                    box.removeClass("collapsed-box");
                });
            }
        },
        remove : function(element) {
            //Find the box parent
            var box = element.parents(".box").first();
            box.slideUp(this.animationSpeed);
        }
    };
}
