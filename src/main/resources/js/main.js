$(document).on('click', '.todo-link', function(){
    var link = $(this);
    var todoId = link.data('id');
    $.ajax({
        method: "GET",
        url: '/todo-list/' + todoId,
        success: function(response)
        {
            if($('.todo-div > span').is('#' + todoId)){
                return;
            }
            link.parent().append(codeDataTodo(response, todoId));
        },
        error: function(response)
        {
            if(response.status == 404) {
                alert('Дело не найдено!');
            }
        }
    });
    return false;
});
$(document).on('click', '#show-update-todo-list', function(){
    var buttonUpdate = $(this);
    var todoId = buttonUpdate.data('id');
    var todoName = buttonUpdate.data('name');
    var todoDescription = buttonUpdate.data('description');
    var todoDate = buttonUpdate.data('date');
    todoFormNameAndButton('Изменить дело', 'Изменить', 'update-todo');
    todoInputValue(todoName, todoDescription, todoDate);
    $('#todo-form').css('display', 'flex');
    $('#update-todo').click(function() {
        var data = $('#todo-form form').serialize();
        $.ajax({
            method: "PUT",
            url: '/todo-list/' + todoId,
            data: data,
            success: function(response) {
                $('#todo-form').css('display', 'none');
                response.date = response.date.slice(0,10);
                $('.todo-div#' + todoId  + ' > a').text(response.name);
                $('.todo-div#' + todoId +' > span').replaceWith(codeDataTodo(response, todoId));
            }
        });
        return false;
    });
});