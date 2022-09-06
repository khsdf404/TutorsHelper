$('document').ready(function () {

    function setTasks() {
        let width = $(`.gridWrapp`).outerWidth();
        $(`.taskWrapp`).append(`<ul></ul>`);
        for (let i = 0; i < 32; i++) {
           $(`.taskWrapp ul`).append(`<li>${i+1}</li>`);
        }
        $(`.taskWrapp ul li`).css({
          'display': 'flex',
          'justify-content': 'center',
          'align-items': 'center',
          'font-size': '16px',
          'background': '#ccc'});
    }
    function setGrid() {
        for (let j = 0; j < 29; j++) {
          $(`.taskWrapp`).append(`<ul></ul>`);
          for (let i = 0; i < 32; i++) {
             $(`.taskWrapp ul`).eq(j+1).append(`<li></li>`);
          }
        }
    }
    function setStudents() {
      let width = $(`.groupWrapp`).outerWidth();
      for (let i = 0; i < 30; i++) {
          $(`.groupWrapp`).append(`<div>${i}. </div>`);
      }
      $(`.groupWrapp div`).eq(0).css({
        'color': 'rgba(45, 45, 45, 0)',
        'background': 'rgba(45, 45, 45, 0.85)',
        'border-top': '0',
        'border-left': '0'})
    }

    setTasks();
    setGrid();
    setStudents();
});
