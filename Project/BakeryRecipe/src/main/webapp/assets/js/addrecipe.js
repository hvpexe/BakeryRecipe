let formElem = document.getElementById('add-recipe');

let instructionElem = document.getElementById('instruction');
formElem.onsubmit = e => {
    e.preventDefault();
}
function checkKeyEnter(e) {
    return e.key === "Enter";
}
function getParam(elem) {
    let result = [];
    for (var i = 0; i < elem.length; i++) {
        var item = elem[i];
        result.push({
            name: item.name,
            value: item.value || '1 ',
        });
        item.value = '';
    }
    return result;
}
function changeImg(elem, value, check) {
    console.log(value);
    if (elem.tagName != 'img') {

        elem.style.backgroundImage = 'url(' + value + ')';
        return;
    } else
        elem.src = value;

}

function ItemCopy(option) {
    var inputElement = $(option.selector);
    function runAjax(url, param, run) {
        $.ajax({
            url: url, data: param,
            success: function (data) {
                console.log(option.container);
                option.run(data, option.container);
            },
            error: function () {
                console.log('error');
            }
        });
    }
    if (option.copy) {
        inputElement.keyup(e => {
            if (checkKeyEnter(e)) {
                var clone = $(option.copy).clone(true);
                option.run(clone, option.container);
            }
        });

    } else
    if (option.url) {
        inputElement.keyup(e => {
            if (checkKeyEnter(e)) {
                runAjax(option.url, getParam(inputElement), option.run);
            }
        });
    } else {
        console.log('error: nothing to copy');
    }

}
;