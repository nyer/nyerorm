(function ($) {
	$.widget("ui.combobox", {
	_create:function () {
		var self = this;
		var select = this.element.hide();
		var input = $("<input>").insertAfter(select);
	input.autocomplete({
		source: function (request, response) {
		var matcher = new RegExp(request.term, "i");
		response(select.children("option").map(function() {
			var text = $(this).text();
			var value= $(this).val();
			if (this.value && (!request.term || matcher.test(text) || matcher.test(value))) {
				return {id: value ,label:$.trim(text) , value : $.trim(text)};
			}
		}));
	}, delay:300 , change:function(event, ui) {
		if (!ui.item) {
			$(this).val("");
			return false;
		}
		select.val(ui.item.id);
	}, minLength:0 }).addClass('text ui-widget-content ui-corner-all');
		
	$('<span class="ui-icon-search-btn" title="下拉菜单"></span>').insertAfter(input).click(function(){
		if (input.autocomplete("widget").is(":visible")) {
			input.autocomplete("close");
			return;
		}
		input.autocomplete("search", "");
		input.focus();
	});
	}});
})(jQuery);