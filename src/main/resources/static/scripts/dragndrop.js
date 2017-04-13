"use strict";

var dragndrop = {
		
	validFileTypes: [],
	uploadFileCallback: undefined,
	
	setValidFileTypes: function(validFileTypes) {
		this.validFileTypes = validFileTypes;
	},
	
	getValidFileTypes: function() {
		return this.validFileTypes;
	},
	
	setUploadFileCallback: function(callback) {
		this.uploadFileCallback = callback;
	},
	
	getUploadFileCallback: function() {
		return this.uploadFileCallback;
	}
};

var isAdvancedUpload = function() {
	var div = document.createElement('div');
	return (('draggable' in div) || ('ondragstart' in div && 'ondrop' in div))
			&& 'FormData' in window && 'FileReader' in window;
}();
	
var box = $('#file-box');
if (isAdvancedUpload) {
	box.addClass('has-advanced-upload');
}
if (isAdvancedUpload) {
	var droppedFiles = false;
	box.on('drag dragstart dragend dragover dragenter dragleave drop', function(e) {
		e.preventDefault();
		e.stopPropagation();
	}).on('dragover dragenter', function() {
		box.addClass('is-dragover');
	}).on('dragleave dragend drop', function() {
		box.removeClass('is-dragover');
	}).on('drop', function(e) {
		droppedFiles = e.originalEvent.dataTransfer.files;
		$.each( droppedFiles, function(i, file) {
			if ($.inArray(file.type, dragndrop.getValidFileTypes()) > -1) {
				dragndrop.getUploadFileCallback()(file);
			}
		});
	});
}