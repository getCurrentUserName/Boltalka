<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-md-12">
    <h3>Добавление нвности</h3>
    <div>
        <div class="form-group input-group col-md-8">
            <input class="form-control" id="title" name="title" placeholder="Заголовок" required>
        </div>
        <div class="form-group input-group col-md-8">
            <textarea class="form-control" rows="10" id="text" name="text" placeholder="Текст" required></textarea>
        </div>
        <button type="submit" id="add" onclick="addNews();" class="btn btn-primary">Добавить</button>

        <div class="toblur">
            <div class="fade in" data-alerts="alerts" data-fade="2000"></div>
        </div>
    </div>
</div>
<script>
    var title = document.getElementById("title");
    var text = document.getElementById("text");

    function addNews() {
        $.post("/api/v1/news/add", {
            text : text.value,
            title : title.value
        })
                .done(function(data) {
                    if (data.result == 'SUCCESS') {
                        clearForm();
                    }
                    addResult(data.result)
                });
    }

    function clearForm() {
        title.innerHTML = '';
        text.innerHTML = '';
    }


    function addResult(data) {
        switch (data) {
            case "SUCCESS":
                $(document).trigger("add-alerts", [
                    {
                        'message': "Успешно добавлен",
                        'priority': 'success'
                    }
                ]);
                break;
            case "OK":
                $(document).trigger("add-alerts", [
                    {
                        'message': "Успешно добавлен",
                        'priority': 'success'
                    }
                ]);
                break;
            case "ERROR":
                $(document).trigger("add-alerts", [
                    {
                        'message': "Ошибка при добавлении",
                        'priority': 'danger'
                    }
                ]);
                break;
            case "NULL":
                $(document).trigger("add-alerts", [
                    {
                        'message': "Дом или услуга не найдена",
                        'priority': 'danger'
                    }
                ]);
                break;
            default:
                $(document).trigger("add-alerts", [
                    {
                        'message': "Произошла неизвестная ошибка",
                        'priority': 'danger'
                    }
                ]);
        }
    }
</script>