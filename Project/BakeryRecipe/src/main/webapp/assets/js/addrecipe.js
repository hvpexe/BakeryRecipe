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
        var clone = newItem('#item', (item) => {
            $.ajax({
                url: "ajax/GetIngredientImage",
                type: "get", //send it through get method
                data: {
                    name: elem.value
                },
                success: function (response) {
                    //Do Something
                    $('#test').html(response);
                },
                error: function (xhr) {
                    //Do Something to handle error
                    $('#test').html('error');
                }
            });
        });
        container.insertBefore(clone, elem);
        elem.value = '';
        clone.setAttribute("disabled", "disabled");
        clone.setAttribute("id", "item1");
        return;
    }
}
function newItem(item, test) {
    var item = document.querySelector(item);
    test(item);
    return item.cloneNode(true);
}