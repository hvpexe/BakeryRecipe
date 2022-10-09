let formElem = document.getElementById('add-recipe');
let instructionElem = document.getElementById('instruction');
formElem.onsubmit = e => {
    e.preventDefault();
}
function ItemCopy(option) {
    var inputElement = $(option.selector);
    function runAjax(url, param, run) {
        var loading = document.createElement('img').src = '';
        $.ajax({
            url: url, data: param,
            success: function (data) {
//                console.log(option.container);                
                option.run(data, option.container, option.count);
            },
            error: function () {
                console.log('error');
            }
        });
    }

    if (option.url) {
        inputElement.keyup(e => {
            var check = true;
            if (checkKeyEnter(e)) {
                for (var i = 0; i < inputElement.length; i++) {
                    if (inputElement[i].value === '')
                        check = false;
                }
            } else {
                check = false;
            }

            if (check)
                runAjax(option.url, getParam(inputElement), option.run);

        });
        document.querySelector('#instruction [class~=accept-input]').onclick = () => {
            var check = true;
            for (var i = 0; i < inputElement.length; i++) {
                if (inputElement[i].value === '')
                    check = false;
            }
            if (check)
                runAjax(option.url, getParam(inputElement), option.run);
        }
    } else {
        console.log('error: nothing to copy');
    }

}
;
function checkKeyEnter(e) {
    var check = e.key === "Enter" && !e.shiftKey;
    if (check) {
        e.preventDefault();
        return true;
    }
    return false;
}
function getParam(elem) {
    let result = [];
    for (var i = 0; i < elem.length; i++) {
        var item = elem[i];
        result.push({
            name: item.name,
            value: item.value || null,
        });
        if (item.type != 'hidden')
            item.value = null;
    }
    return result;
}
//elem : the element will be shown to #detail .container
function showDetail(elem) {
    let detail = document.querySelector('#detail');
    detail.setAttribute('viewing', elem.id);
    detail.querySelector('textarea').value = elem.querySelector('[name=inst-description]').value;
    detail.querySelector('textarea').innerText = elem.querySelector('[name=inst-description]').value;
    detail.classList.remove('d-none');
    detail.querySelector('[name=step]').value = elem.querySelector('[name=step]').value;
    detail.querySelector('[name=step]').click();
    let imgValue = elem.querySelector('input[type=file]').value;
    if (imgValue) {
        detail.querySelector('img').parentElement.classList.remove('fas', 'fa-camera');
        detail.querySelector('img').classList.remove('d-none');
        detail.querySelector('img').src = elem.querySelector('input[type=file]').parentElement.src;
    } else {
        detail.querySelector('img').parentElement.classList.add('fas', 'fa-camera');
        detail.querySelector('img').classList.add('d-none');
    }
}
function changeIngrImg(elem, value, e) {
    if (elem.tagName !== 'IMG') {
        elem.style.backgroundImage = 'url(' + value + ')';
        elem.classList.remove('fas', 'fa-camera');
        elem.src = value;
    } else {
        elem.src = value;
        elem.classList.remove("d-none");
        elem.parentElement.classList.remove('fas', 'fa-camera')
    }
}
$('.save-btn').on('click', e => {
    var detail = document.querySelector("#detail");
    var elem = document.getElementById(detail.getAttribute('viewing'));
    elem.querySelector('[name=inst-description]').value = detail.querySelector('textarea').value;
    elem.querySelector('[name=inst-image]').value = detail.querySelector('img').src;

    console.log(detail);
    console.log(elem);
    document.querySelector("#detail").classList.add('d-none');

});
// stop img that have a camera calling ShowDetail first
$('#inst-container h5, #inst-container .inst-img, #inst-container .inst-img *\n\
                                                ,#inst-container .item-trashbin, #inst-container .item-trashbin *').click(function (e) {
    e.stopPropagation();
});
// #detail exit btn
$('#detail :is(.gray-box, .exit-btn, .cancel-btn, .save-btn)').click(e => {
    document.querySelector("#detail").classList.add('d-none');
});
