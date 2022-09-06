$('document').ready(function () {
    let groupList = [  "Астахов Никита",  "Борисов Денис",  "Вдовичев Никита",  "Жирнов Никита",  "Заикин Даниил",  "Зворыкин Глеб",  "Козлова Мария ",  "Крутиков Никита",  "Лосев Антон",  "Макарова Александра",  "Муратор Тимур",  "Назаренко Екатерина",  "Никитин Артём",  "Новоселова Татьяна",  "Орлов Данил",  "Пискун Дмитрий",  "Проходцев Сергей",  "Рахманов Амир",  "Редков Максим",  "Романенко Андрей",  "Рыжков Александр",  "Семенов Александр",  "Семянников Никита",  "Степанов Константин",  "Чеснаков Максим",  "Чикилев Данил",  "Чуркин Максим",  "Широков Антон",  "Шрестха Алекс",  "test" ]  ;
    let taskList = [  "--------------------------------",  "--------------------------------",  "--------------------------------",  "--------------------------------",  "--------------------------------",  "--------------------------------",  "-----+--------------------------",  "------------------+-------------",  "--------------------------------",  "--------------------------------",  "--------------------------------",  "--------------------------------",  "--------------------------------",  "--------------------------------",  "++++++--------------------------",  "--------------------------------",  "--------------------------------",  "------------------+-------------",  "----+---------------------------",  "--------------------------------",  "--------------------------------",  "--------------------------------",  "--------------------------------",  "--------------------------------",  "--------------------------------",  "--------------------------------",  "--------------------------------",  "--------------------------------",  "--------------------------------",  "--------------------------------" ]  ;
    let taskAmount = taskList[0].length;
    let studentAmount = groupList.length;
    function setTasks() {
        let width = $(`.gridWrapp`).outerWidth();
        $(`.taskWrapp`).append(`<ul></ul>`);
        for (let i = 0; i < taskAmount; i++) {
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
        for (let j = 0; j < studentAmount; j++) {
          $(`.taskWrapp`).append(`<ul></ul>`);
          for (let i = 0; i < taskAmount; i++) {
            let cl =  taskList[j][i]  == `+` ? 'liTrue' : 'liFalse';
             $(`.taskWrapp ul`).eq(j+1).append(`<li class=${cl}></li>`);
          }
        }
    }
    function setStudents() {
      let width = $(`.groupWrapp`).outerWidth();
      $(`.groupWrapp`).append(`<div>123</div>`);
      for (let i = 0; i < studentAmount; i++) {
          $(`.groupWrapp`).append(`<div>  ${i + 1}. ${groupList[i]}</div>`);
      }
      $(`.groupWrapp div`).eq(0).css({
        'color': 'rgba(45, 45, 45, 0)',
        'background': 'transparent',
        'border-top': '1px solid',
        'border-left': '1px solid'
      });
      $(`.groupWrapp div`).css({
        'max-height': $(`.taskWrapp ul li`).eq(0).outerHeight()
      });
    }
    function setFontSize() {
        let max = 0;
        for (let i = 0; i < groupList.length; i++)
          if (groupList[i].length > max) max = groupList[i].length;
          let fs = 2*$(`.groupWrapp div`).outerWidth()/(max + 6);
          fs += $(`.groupWrapp div`).outerHeight()/(1.6);
          let fontSize = fs/2.5 + 'px';
        $(`.groupWrapp div`).css({
          'font-size': fontSize
        });
    }

    setTasks();
    setGrid();
    setStudents();
    setFontSize();
    $(window).resize(function () {
          setFontSize();
          $(`.groupWrapp div`).css({
            'max-height': $(`.taskWrapp ul li`).eq(0).outerHeight()
          });
    })

});
