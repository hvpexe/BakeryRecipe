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
        var count = parseInt(elem.dataset.count) + 1;
        // i want the newItem function to insert in the id and the new ID so that 
        // i can insert new searched element 
        var clone = newItem('#item', 'item' + count);
        $.ajax({
            url: "ajax/GetIngredientImage",
            type: "get", //send it through get method
            data: {
                name: elem.value
            },
            success: function (response) {
                //Do Something
                var id = clone.id;

                $(clone.item).html(response);
                container.insertBefore(clone.item, elem);
                //img tag
                $(clone.item).children()[0].onerror = () => {
                    this.src = "assets/images/ingredients/default.png";
                }
                //trashbin tag
                $(clone.item).children()[2].onclick = (e) => {
                    e.target.parentElement.remove();
                }
                elem.value = '';
                elem.setAttribute('data-count', count);
            },
            error: function (xhr) {
                //Do Something to handle error
                $('#test').html('error');
            }
        });
        return;
    }
}
function newItem(item, newID, test) {
    var item = document.querySelector(item).cloneNode();
    item.setAttribute("id", newID);
    return {
        id: '#' + newID,
        item: item
    };
}
function changeImg(elem, value) {
    console.log(value);
    elem.src = value;
} 