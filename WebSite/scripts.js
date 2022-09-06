$('document').ready(function () {
    let startHeight = $(`.gridWrapp`).outerHeight();
    function setHeight() {
        $('.wrapp').css({'height': 30*startHeight/32});
    }
    function setTasks() {
        let width = $(`.gridWrapp`).outerWidth();
        $(`.taskWrapp`).append(`<ul></ul>`);
        for (let i = 0; i < 32; i++) {
           $(`.taskWrapp ul`).append(`<li></li>`);
        }
        $(`.taskWrapp ul li`).css({
          'width': (startHeight - 32* 2)/32,
          'height': (startHeight - 32* 2)/32,
          'background': '#ccc'});
    }
    function setGrid() {
        for (let j = 0; j < 29; j++) {
          $(`.taskWrapp`).append(`<ul></ul>`);
          for (let i = 0; i < 32; i++) {
             $(`.taskWrapp ul`).eq(j+1).append(`<li></li>`);
          }
          $(`.taskWrapp ul li`).css({
              'width': (startHeight - 32* 2)/32,
              'height': (startHeight - 32* 2)/32});
        }
    }
    function setStudents() {
      let width = $(`.groupWrapp`).outerWidth();
      for (let i = 0; i < 30; i++) {
          $(`.groupWrapp`).append(`<div></div>`);
      }
      $(`.groupWrapp div`).css({
        'width': width - 2,
        'height': (startHeight - 32* 2)/32
      });

      $(`.groupWrapp div`).eq(0).css({'background': '#454545'})
    }


    setHeight();
    setTasks();
    setGrid();
    setStudents();
});
