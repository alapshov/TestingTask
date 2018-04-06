$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Test.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "# language: ru"
    }
  ],
  "line": 3,
  "name": "тестировние яндекс маркета",
  "description": "",
  "id": "тестировние-яндекс-маркета",
  "keyword": "Функция",
  "tags": [
    {
      "line": 2,
      "name": "@withdrawal"
    }
  ]
});
formatter.scenario({
  "comments": [
    {
      "line": 5,
      "value": "#Предыстория:"
    },
    {
      "line": 6,
      "value": "#Если перейти на яндекс маркет"
    },
    {
      "line": 7,
      "value": "# То открывается страница яндекс маркет"
    }
  ],
  "line": 10,
  "name": "выполнить проверку яндекс маркет",
  "description": "",
  "id": "тестировние-яндекс-маркета;выполнить-проверку-яндекс-маркет",
  "type": "scenario",
  "keyword": "Сценарий",
  "tags": [
    {
      "line": 9,
      "name": "@success"
    }
  ]
});
formatter.step({
  "line": 11,
  "name": "выбрать первый раздел ПервыйРаздел",
  "keyword": "Если "
});
formatter.step({
  "line": 12,
  "name": "выбрать второй раздел ВторойРаздел",
  "keyword": "И "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
});