/* Author:

*/



(function() {
  
  // Collapsed list
  var collapsedLists = $('.ui-collapsedList');
  collapsedLists.each(function(i, element) {
    var collapsedList = $(element);
    var collapsedListTitle = collapsedList.find('.ui-collapsedList-title');
    var collapsedListBody = collapsedList.find('.ui-collapsedList-body');
    collapsedListTitle.click(function() {
      collapsedListBody.slideToggle();
      collapsedList.toggleClass('ui-state-collapsed');
    });
  });

  // Toggle radio
  $('.toggle-radio').each(function(i, element) {
    var toggleRadio = $(element);
    var lastVisibleEl;
    $('input[type="radio"]', toggleRadio).change(function() {
      var targetId = $(this).data('toggle-radio');
      lastVisibleEl && lastVisibleEl.addClass('hidden');
      if (!!targetId) {
        var target = $('#' + targetId);
        lastVisibleEl = target.removeClass('hidden');
      }
    });
  });

  // Toggle radio
  $('.toggle-checkbox').each(function(i, element) {
    var elementJq = $(element);
    var targetId = elementJq.data('toggle-checkbox');
    var target = $('#' + targetId); 
    elementJq.change(function() {
      var method = element.checked ? 'removeClass' : 'addClass';
      target[method]('hidden');
    });
  });

   // Toggle select
  $('.toggle-select').each(function(i, element) {
    var elementJq = $(element);
    var targetId = elementJq.data('toggle-select');
    var target = $('#' + targetId); 
    elementJq.change(function() {
      $.each(element.options, function(i, option) {
        if (option.selected) {
          target.empty();
          var optionValueAry = option.getAttribute('data-toggle-select').split(',');
          $.each(optionValueAry, function(i, optionValue) {
            var optionValueAry =  optionValue.split(':');
            var optionValue = optionValueAry[0];
            var optionText = optionValueAry[1] || optionValue;
            var option = $('<option value="'+ optionValue+ '">' + optionText + '</option>');
            option.appendTo(target);
          });
        }
      });
    });
  });


  var customParameter = {
    init: function() {
      this.root = $('#build-custom-parameter');
      this.customParameterContainer = $('#custom-parameter-container');
      this.bindEvent();
    },

    bindEvent: function() {
      var self = this;
      $('#build-custom-parameter-num', this.root).keyup(function() {
        var num = +this.value;
        if (num === NaN) return;
        var el = self.buildEls(num);
      });
    },

    buildEls: function(num) {
      var el;
      this.customParameterContainer.empty();
      for (var i = 0; i < num; ++i) {
        el = $(['<li style="margin: .3em 0">',
          '<input type="text" placeholder="属性" name="custom-parameter[' + num + '][key]">',
          '<input type="text" placeholder="值" style="margin-left: 4px" name="custom-parameter[' + num + '][value]">',
          '</li>'].join(''));

        this.customParameterContainer.append(el);
      }
    }
  };

  customParameter.init();


})();

