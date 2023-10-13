package org.example;

import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class Consumer {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate(); // класс, предоставляемый библиотекой Spring Framework, который упрощает выполнение HTTP-запросов к удаленным RESTful веб-сервисам.
        // Получение JSON ответа от REST API сервиса при использовании GET запроса
        String url = "https://reqres.in/api/users/2";  // Создаем GET (без параметров) запрос на необходимый URL
        String response = restTemplate.getForObject(url, String.class);  // Отправляем запрос, получаем ответ в виде String
        System.out.println(response);  // Выводит JSON ответ в консоль

        //  Получение JSON ответа от REST API сервиса при использовании POST запроса
        Map<String, String> jsonToSend = new HashMap<>(); // В соответствии с необходимым JSON запросом создаем MAP содержащий ключи и данные необходимы для JSON
        jsonToSend.put("name", "Имя пользователя"); // Заполняем MAP данными, где name - ключ, morpheus - значение
        jsonToSend.put("job", "Место работы пользователя"); // Заполняем MAP данными

        HttpEntity<Map<String, String>> request = new HttpEntity<>(jsonToSend); // Упаковываем HashMap в JSON запрос, используя объект HttpEntity

        String url2 = "https://reqres.in/api/users";
        String response2 = restTemplate.postForObject(url2, request, String.class); // Отправляем JSON запрос, первый аргумент адрес для запроса, второй аргумент сам json запрос, 3 аргумент - ответ на полученный запрос.
        System.out.println(response2);  // Выводит JSON ответ в консоль
    }
}
