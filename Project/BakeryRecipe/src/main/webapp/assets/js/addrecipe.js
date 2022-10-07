let formElem = document.getElementById('add-recipe');
let ingredentElem = document.getElementById('ingredient');
formElem.onsubmit = e => {
    e.preventDefault();
}
ingredentElem.onkeyup = e => {

    if (e.key === 'Enter') {
        var elem = e.target;
        var container = elem.parentElement;
        //jQuery.get( url [, data ] [, success ] [, dataType ] ); 
        var count = elem.getAttribute('data-count') + 1;
        var clone = newItem('#item', 'item' + count, (item) => {
            item = '#' + item;
            $.ajax({
                url: "ajax/GetIngredientImage",
                type: "get", //send it through get method
                data: {
                    name: elem.value
                },
                success: function (response) {
                    //Do Something
                    $(item).html(response);
                    container.insertBefore(clone, elem);
                    elem.value = '';
                    elem.setAttribute('data-count',count);
                },
                error: function (xhr) {
                    //Do Something to handle error
                    $(item).html('error');
                }
            });
        });
        //finnally

        return;
    }
}
function newItem(item, newID, test) {
    var item = document.querySelector(item).cloneNode();
    item.setAttribute("id", newID);
    test(item.id);
    return item;
}