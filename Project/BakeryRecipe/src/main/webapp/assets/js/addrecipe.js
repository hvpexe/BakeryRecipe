let formElem = document.getElementById('add-recipe');
$('#inst-container .inst-img').click(function (e) {
    e.stopPropagation();
});
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
            var check = false;
            for (var i = 0; i < inputElement.length; i++) {
                var item = inputElement[i];
                if (item.value !== '' && item.type !== 'hidden')
                    check = true;
            }
            if (check) {
                check = checkKeyEnter(e);
                if (check)
                    runAjax(option.url, getParam(inputElement), option.run);
            }
        });
        document.querySelector('#instruction [class~=accept-input]').onclick = () => {
            runAjax(option.url, getParam(inputElement), option.run);
        }
    } else {
        console.log('error: nothing to copy');
    }

}
;s
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

function showDetail(elem) {
    window.event.cancelBubble = true;
    window.event.stopPropagation();
    console.log(elem);
    document.querySelector('#detail').classList.remove('d-none');
}
function changeIngrImg(elem, value, e) {
    e.cancelBubble = true;
    e.stopPropagation();
    if (elem.tagName != 'img') {
        elem.style.backgroundImage = 'url(' + value + ')';
        elem.classList.remove('fas', 'fa-camera');
        return;
    } else
        elem.src = value;

}


// #detail exit btn
document.querySelector('#detail .gray-box').onclick = e => {
    e.target.parentElement.classList.add('d-none');
};
document.querySelector('#detail .exit-btn').onclick = e => {
    e.target.parentElement.classList.add('d-none');
};