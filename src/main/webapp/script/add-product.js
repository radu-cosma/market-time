"use strict";

var 
	//validation rules for the whole form
	validationConfig = {
	    'name' : {
	        'required' : true,
	        'minLength' : 3,
	        'maxLength' : 30,
	        'messages' : {
	            'required' : 'Please insert a name for your product.',
	            'lessThan' : 'The product name should have at least 3 characters.',
	            'moreThan' : 'The product name should have at most 30 characters.'
	        }
	    },
	    'description' : {
	        'required' : true,
	        'minLength' : 3,
	        'maxLength' : 1000,
	        'messages' : {
	            'required' : 'Please insert a description for your product.',
	            'lessThan' : 'The product description should have at least 3 characters.',
	            'moreThan' : 'The product description should have at most 1000 characters.'
	        }
	    },
	    'tags' : {
	        'required' : true,
	        'minLength' : 3,
	        'maxLength' : 200,
	        'regexp' : /^([a-zA-Z]{3,})(,\s*[a-zA-Z]{3,})*$/,
	        'messages' : {
	            'required' : 'Please insert at least a tag for your product.',
	            'lessThan' : 'The product tags field should have at least 3 characters.',
	            'moreThan' : 'The product tags field should have at most 200 characters.',
	            'invalidRegexp' : 'A tag should contain lowercase and uppercase letters only. Multiple tags should be comma separated.'
	        }
	    },
	    'shipping' : {
	        'required' : true,
	        'minLength' : 3,
	        'maxLength' : 10,
	        'messages' : {
	            'required' : 'This field is required.',
	            'lessThan' : 'Shipping should have at least 3 characters.',
	            'moreThan' : 'Shipping should have at most 10 characters.'
	        }
	    },
	    'shipping-time' : {
	        'required' : false,
	        'minLength' : 3,
	        'maxLength' : 10,
	        'regexp' : /^[0-9]{1,2}-[0-9]{1,2}$/,
	        'messages' : {
	            'lessThan' : 'Shipping time should have at least 3 characters.',
	            'moreThan' : 'Shipping time should have at most 5 characters.',
	            'invalidRegexp' : 'The shipping time should be expressed as a range of days, like 15-20.'
	        }
	    },
	    'color' : {
	        'required' : false,
	        'minLength' : 3,
	        'maxLength' : 20,
	        'messages' : {
	            'lessThan' : 'The product color should have at least 3 characters.',
	            'moreThan' : 'The product color should have at most 20 characters.'
	        }
	    },
	    'size' : {
	        'required' : false,
	        'minLength' : 1,
	        'maxLength' : 10,
	        'messages' : {
	            'lessThan' : 'The product size should have at least 1 character.',
	            'moreThan' : 'The product size should have at most 10 characters.'
	        }
	    },
	    'inventory' : {
	        'required' : true,
	        'messages' : {
	            'required' : 'The number of products on stock is required.'
	        }
	    },
	    'price' : {
	        'required' : true,
	        'messages' : {
	            'required' : 'The product price is required.'
	        }
	    },
	    'brand' : {
	        'required' : false,
	        'minLength' : 3,
	        'maxLength' : 30,
	        'messages' : {
	            'lessThan' : 'The product brand should have at least 3 characters.',
	            'moreThan' : 'The product brand should have at most 30 characters.'
	        }
	    },
	    'presentationPageUrl' : {
	        'required' : false,
	        'minLength' : 10,
	        'maxLength' : 50,
	        'messages' : {
	            'lessThan' : 'The product presentation page URL should have at least 10 characters.',
	            'moreThan' : 'The product presentation page URL should have at most 50 characters.'
	        }
	    },
	    'upc' : {
	        'required' : false,
	        'exactLength' : 12,
	        'regexp' : /^[0-9]{12}$/,
	        'messages' : {
	            'lessOrMoreThan' : 'The product UPC should contain exactly 12 digits.',
	            'invalidRegexp' : 'The product UPC should contain exactly 12 digits.'
	        }
	    }
	},
	
	//validation rules for add image url input
	imageUrlValidationConfig = {
		'add-image-url-input' : {
	        'required' : true,
	        'regexp' : /(https?:\/\/(?:www\.|(?!www))[^\s\.]+\.[^\s]{2,}|www\.[^\s]+\.[^\s]{2,})/,
	        'messages' : {
	        	'required' : 'Add an image URL.',
	            'invalidRegexp' : 'The image URL has an invalid format.'
	        }
	    }
	},
	
	//function that checks the existence of at least a product image
	checkForImages = function() {
		if ($('.product-image-container').length > 0) {
			return true;
		} else {
			$('#file-box').addClass('has-error');
			return false;
		}
	},
	
	//function that handles the addition of a new product image, by updating the UI and calling the backend web service.
	addProductImage = function(imageData, successCallback) {
		var productImagesContainer = $('#product-images-container'),
			imageContainer = $('<div></div>').addClass('product-image-container').attr('weight', imageData.weight),
			imageThumbnail = $('<img></img').addClass('image-thumbnail faded').attr('draggable', 'false'),
			removeImageButton = $('<a></a>').addClass('remove-image-button').attr('title', 'Remove');
		 	
		removeImageButton.on('click', removeImage);
		imageContainer.append(removeImageButton);
		imageContainer.append(imageThumbnail);
		productImagesContainer.append(imageContainer);
		
		if (typeof imageData.imageData !== 'undefined') {
			imageThumbnail.attr('src', imageData.imageData);
			imageData.imageData = imageData.imageData.replace('data:'+ imageData.type + ';base64,', '');
		} else if (typeof imageData.url !== 'undefined') {
			imageThumbnail.attr('src', imageData.url);
		}
		
		$.ajax({
		    type: 'POST',
		    url: '/market-time/rest/products/addImage',
		    dataType: 'json',
		    contentType: 'application/json',
		    data: JSON.stringify(imageData),
		    success: function(response) {
		        if (response.generalError) {
		        	alert(response.generalError);
		        } else if(response.validationErrors) {
		        	alert(response.validationErrors);
		        } else {
		        	imageThumbnail.removeClass('faded');
		        	if (typeof successCallback !== 'undefined') {
		        		successCallback();
		        	}
		        }
		    },  
		    error: function(e) {
		    	console.log(e);
		    }  
		});
	},
	
	//success callback function used when adding an image by url
	addImageByUrlSuccessCallback = function() {
		$('#add-image-url-input').val('');
	},
	
	//function that handles the addition of an image by selecting it from the file system or by dragging and dropping it in the browser window
	uploadFile = function(file) {
		var reader = new FileReader();
		reader.onload = function(evt) {
			var imageData = { 
				'name' : file.name,
				'type' : file.type,
				'weight': $('.product-image-container').length + 1,
				'imageData': evt.target.result,
				'addProductSessionId': $('#add-product-session').val()
			};
	    	addProductImage(imageData);
	    };
	    reader.readAsDataURL(file);
	},
	
	//function that calls the remove image web service
	removeImage = function() {
		var imageContainer = $(this).parent(),
			imageWeight = imageContainer.attr('weight');
		$.ajax({
			type: 'POST',
		    url: '/market-time/rest/products/removeImage',
		    dataType: 'json',
		    contentType: 'application/json',
		    data: JSON.stringify({
		    	'weight': imageWeight,
		    	'addProductSessionId': $('#add-product-session').val()
		    }),
		    success: function(response) {
		        if (!response.generalError && !response.validationErrors) {
		        	imageContainer.remove();
		        	recalibrateWeights();
		        }
		    },  
		    error: function(e) {
		    	console.log(e)
		    }  
		});
	},
	
	recalibrateWeights = function() {
		var previousImageWeight = 0;
		$('.product-image-container').each(function() {
			$(this).attr('weight', ++previousImageWeight);
		});
	},
	
	//default image types
	defaultValidImageTypes = ["image/gif", "image/jpg", "image/jpeg", "image/png", "gif", "jpg", "jpeg", "png"],
	validImageTypes = defaultValidImageTypes;

$('form').on('submit', function(evt) {
    var inputIds = $(this).find('input').map(function() {
        return this.id;
    }).get();

    var hasImages = checkForImages(),
    	isValid = validator.validateForm(inputIds, validationConfig);

    if (!isValid && !hasImages) {
        evt.preventDefault();
    }
});

$('.close').on('click', function(evt) {
    evt.preventDefault();
    $(this).parent().addClass('hidden');
});

$('#add-image-url-button').on('click', function(evt) {
	var isValid = validator.validateForm(['add-image-url-input'], imageUrlValidationConfig);
	if (isValid) {
		var imageUrl = $('#add-image-url-input').val(),
		 	fullImageName = imageUrl.slice(imageUrl.lastIndexOf('/') + 1, imageUrl.lastIndexOf('?') != -1 ? imageUrl.lastIndexOf('?') : imageUrl.length),
		 	imageName = fullImageName.split('.')[0],
		 	imageType = fullImageName.split('.')[1],
		 	imageData = { 
				'name' : imageName, 
				'type' : imageType, 
				'weight': $('.product-image-container').length + 1,
				'url': imageUrl,
				'addProductSessionId': $('#add-product-session').val()
			};
		addProductImage(imageData, addImageByUrlSuccessCallback);
	}
});

$('#file-box-file').on('change', function(evt) {
	$.each(this.files, function(i, file) {
		if ($.inArray(file.type, validImageTypes) > -1) {
			uploadFile(file);
		}
	});
});

$.ajax({
	type: 'GET',
    url: '/market-time/rest/products/getImageTypes',
    contentType: 'application/json',
    success: function(response) {
        if (!response.generalError && !response.validationErrors) {
        	validImageTypes = response.result;
        }
    },  
    error: function(e) {
    	console.log(e)
    }  
});
dragndrop.setUploadFileCallback(uploadFile);
dragndrop.setValidFileTypes(validImageTypes);
