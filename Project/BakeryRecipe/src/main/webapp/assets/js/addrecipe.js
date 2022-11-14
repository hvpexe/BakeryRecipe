/* global URL */

let formElem = document.getElementById('add-recipe');
let instructionElem = document.getElementById('instruction');
$('input').keydown(function (e) {
    if (e.key === 'Enter')
        e.preventDefault();
});
async function submitForm(selector) {
    const form = document.getElementById('add-recipe');
    var inputs = form.querySelectorAll('[name][count]:not([disabled])');
    var smbtn = document.getElementById('submit');
    const output = document.getElementById('test');
    var cover = document.querySelector('[name=cover]');
    var coverNode = document.querySelectorAll('#img-content [name=video-image]');
    var i = 0;
    cover.value = 0;
    coverNode.forEach(x => {
        x.parentNode.classList.contains('cover') ? cover.value = i : '';
        i++;
    });
    for (var i = 0; i < inputs.length; i++) {
        inputs[i].setAttribute('name', inputs[i].getAttribute('name') + inputs[i].getAttribute('count'));
    }
    console.log(output);
    smbtn.click();
}
//add video and picture
var swiper = new Swiper(".swiper", {
    slidesPerView: 4,
//    centeredSlides: true,
    spaceBetween: 30,
    freeMode: true,
});
var appendNumber = 4;
var prependNumber = 1;

// video and image
document.querySelectorAll('#img-content .image').forEach(
        x => x.onclick
            = e => selectContent(document.querySelector('#img-content'), e.target));

document.querySelector("#add-video-btn").onclick = () => addVideo('#img-content');
document.querySelector("#add-img-btn").onclick = () => addImage('#img-content');
document.querySelector("#img-content .add-img").onclick = () => addImage('#img-content');
document.querySelector('#remove-image').onclick = () => removeImage('.video-and-image .selected');
//this 
async function addVideo(container) {
    var container = document.querySelector(container);
    var videoBtn = document.querySelector("#add-video-btn");
    var video = container.querySelector(".video");
    var inputs = container.querySelectorAll('input');
    var check = false;
    //when user click on add video or update video this function activate
    await showBox({
        selector: '#img-box',
        container: container.parentElement,
        video: video,
        url: inputs[0],
        btn: videoBtn,
    });
}

// this will change the value of the video class
async function showBox(option) {
    var box = document.querySelector(option.selector);
    box.classList.remove('d-none');
    var inputs = box.querySelectorAll('input');
    var isYoutubeRegex = /^((?:https?:)?\/\/)?((?:www|m)\.)?((?:youtube\.com|youtu.be))(\/(?:[\w\-]+\?v=|embed\/|v\/)?)([\w\-]+)?(\S+)?$/s;
    var check = false;
    inputs[0].value = option.url.value;
    inputs[0].oninput = e => {
        var status = e.target.parentElement.querySelector('.status');
        var url = e.target.value;
        status.innerText = "";
        inputs[0].classList.remove('border-danger');
        inputs[0].classList.remove('border-success');
        check = isYoutubeRegex.test(url);
        if (check) {
            inputs[0].classList.add('border-success');
        }
    }
    inputs[0].onblur = e => {
        var status = e.target.parentElement.querySelector('.status');
        var url = e.target.value;
        console.log(e.target.value + " ggggggg");
        check = isYoutubeRegex.test(url);
        if (!check) {
            inputs[0].classList.add('border-danger');
            inputs[0].classList.remove('border-success');
            status.innerText = "Please input Youtube URL";
            console.log("false");
            console.log(check);
            box.querySelector('.save-btn').onclick = () => {
            };
        }
        if (check) {
            status.innerText = "";
            inputs[0].classList.remove('border-danger');
            inputs[0].classList.add('border-success');
            console.log("true");
        }
        if (check) {
            // if check == true add a video 
            box.querySelector('.save-btn').onclick = () => {
                showVideo(option, inputs);
                box.classList.add('d-none');
            };
        }
        ;
    }

}
function getLinkEmbed(value) {
    var embedUrl = value.match(/[\w\-]{11,}/)[0];
    return 'https://www.youtube.com/embed/' + embedUrl;
}
function getLinkImg(value) {
    var imgUrl = value.match(/[\w\-]{11,}/)[0];
    return 'https://img.youtube.com/vi/' + imgUrl + '/0.jpg';
}
function showVideo(option, inputs) {
    var imgUrl = getLinkImg(inputs[0].value);
    option.url.value = inputs[0].value;
    option.container.classList.remove('d-none');
    option.btn.innerHTML = option.btn.innerHTML.replace('Add', "Update");
    option.video.classList.remove('d-none');
    option.video.style.backgroundImage = 'url(' + imgUrl + ')';
}
function hideVideo(option) {
    option.input.value = '';
    option.url.value = '';
    option.url.classList.remove('border-success');
    option.btn.innerHTML = option.btn.innerHTML.replace('Update', "Add");
    option.video.classList.add('d-none');
    option.video.classList.remove('selected');
}
// add image 
var picCount = document.querySelector('#display-img');
function addImage(container) {
    var container = document.querySelector(container);
    var images = container.querySelectorAll('.image');
    var span = document.createElement('span');
    var inputPicture = document.createElement('input');
    inputPicture.setAttribute('type', 'file');
    inputPicture.setAttribute('name', 'video-image');
    inputPicture.setAttribute('class', 'd-none');
    inputPicture.setAttribute('count', picCount.getAttribute('count'));
    //    inputPicture.setAttribute('onclick', 'changeImg(this)');
    span.classList = "col-2 p-0 swiper-slide hover-button-2 image list-group-item  rounded ";
    span.appendChild(inputPicture);
    inputPicture.click();
    container.parentElement.classList.remove("d-none");
    span.onclick = e => {
        selectContent(container, e.target);
    };
    inputPicture.onchange = e => {
        changeImg(e.target.parentElement, getObjURL(e.target.files[0]), e);
        swiper.appendSlide(span);
        picCount.setAttribute('count', parseInt(picCount.getAttribute('count')) + 1);
        updateCount(container);
    };
}
function removeImage(selector) {
    var elem = document.querySelector(selector);
    var display = document.querySelector('#display-img');
    console.log(elem);
    if (elem.classList.contains("cover")) {
        document.querySelector('[name=cover]').setAttribute('value', 0);
    }
    if (elem.classList.contains("video")) {
        hideVideo({
            input: document.querySelector('#img-content input'),
            url: document.querySelector("[name=vurl]"),
            video: elem,
            btn: document.querySelector("#add-video-btn")
        });
    } else {
        elem.remove();
    }
    display.classList.add('d-none');
}
function updateCount(container) {
//    var inputs = container.querySelectorAll('input[count]');
//    for (var i = 0; i < inputs.length; i++) {
//        inputs[i].setAttribute('count', i);
//    }
}
//elem the .selected picture
//this method will run when user select an image
var display = document.querySelector('#display-img');
var displayImage = display.querySelector('.image');
var displayVideo = display.querySelector('.video');
var toCoverBtn = document.querySelector('#to-cover-btn');
var changeImgBtn = document.querySelector('#change-img-btn');

function selectContent(container, elem) {
    container.querySelector('.selected')?.classList.remove('selected');
    elem.classList.add('selected');
    display.classList.remove('d-none');
    var img;

    if (!elem.classList.contains('video')) {
        img = elem.getAttribute('src');
        displayImage.style.backgroundImage = 'url(' + img + ')';
        displayImage.setAttribute('src', img);
        toCoverBtn.classList.remove('d-none');
        changeImgBtn.classList.remove('d-none');
        displayImage.classList.remove('d-none');
        displayVideo.classList.add('d-none');
        toCoverBtn.onclick = () => {
            setCover(elem);
        }
        changeImgBtn.onclick = () => {
            changeDisplayImage(elem, displayImage);
        };
    } else {
        toCoverBtn.classList.add('d-none');
        changeImgBtn.classList.add('d-none');
        displayImage.classList.add('d-none');
        displayVideo.classList.remove('d-none');
        displayVideo.setAttribute('src', getLinkEmbed(elem.querySelector('input').value));
        displayVideo.contentDocument.location.reload(true);
        displayVideo.src += '';
        console.log(elem.querySelector('input').value);
    }
}
function setCover(elem) {
    elem.parentElement.querySelector('.cover')?.classList.remove('cover');
    elem.classList.add('cover');
    var cover;
    cover = elem.querySelector('input').getAttribute('count');
    console.log(elem);
    document.querySelector('[name=cover]').setAttribute('value', cover);
}

async function changeDisplayImage(elem, image) {
    var inputPicture = elem.querySelector('input');
    inputPicture.click();
    inputPicture.onchange = e => {
        changeImg(inputPicture.parentElement, getObjURL(inputPicture.files[0]), e);
        elem.click();
        image.style.backgroundSize = '';
    };
    elem.click();

}
function getObjURL(file) {
    url = URL.revokeObjectURL(file);
    return url || URL.createObjectURL(file);
}












// item copy
function ItemCopy(option) {
    var inputElement = $(option.selector);
    function runAjax(url, param, run) {
        var loading = document.createElement('img').src = '';
        $.ajax({
            url: url, data: param,
            success: function (data) {
                //                console.log(option.container);                
                run(data, option.container, option.count);
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
                if (inputElement[0].value === '')
                    check = false;
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
            value: item.value.replace(/^\w/, c => c.toUpperCase()) || '1',
        });
        if (item.type !== 'hidden')
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
        detail.querySelector('img').src = elem.querySelector('input[type=file]').parentElement.getAttribute('src');
    } else {
        detail.querySelector('img').parentElement.classList.add('fas', 'fa-camera');
        detail.querySelector('img').classList.add('d-none');
    }
}
//elem the elem you want to edit
//value the src 
//e maybe use
async function changeImg(elem, value, e) {
    if (elem.tagName !== 'IMG') {
        elem.style.backgroundImage = 'url(' + value + ')';
        elem.classList.remove('fas', 'fa-camera');
        elem.setAttribute('src', value);
    } else {
        elem.parentElement.classList.remove('fas', 'fa-camera');
        elem.classList.remove("d-none");
        elem.setAttribute('src', value);
    }
}
function updateContainer(container) {
    if (typeof container === 'string')
        container = document.querySelector(container);
    console.log(container);
    let instList = container.querySelectorAll('#' + container.id + ' > [id^=inst]');
    console.log(instList);
    for (var i = 0; i < instList.length; i++) {
        var step = instList[i].querySelector('[name=step]');
        step.setAttribute('value', i);
        step.click();
    }
}
//removeElem
function removeElem(elem) {
    let container = elem.parentElement;
    let instContainer = container.parentElement;
    container.remove();
    updateContainer(instContainer);
}
//#detail save button
$('#detail .save-btn').on('click', e => {
    var detail = document.querySelector("#detail");
    var elem = document.getElementById(detail.getAttribute('viewing'));
    elem.querySelector('[name=inst-description]').value = detail.querySelector('textarea').value.replace(/^\w/, c => c.toUpperCase());
    let elemFile = elem.querySelector('[name*=inst-image]');
    let detailFile = detail.querySelector('input[type=file]');
    if (detailFile.files[0]) {
        let clone = detailFile.cloneNode(true);
        //<input name="inst-image1" id="inst-image1" class="d-none" readonly="" type="file" accept="image/*" onchange="changeIngrImg(this.parentElement, window.URL.createObjectURL(this.files[0]), event)">
        clone.setAttribute('name', elemFile.name);
        clone.setAttribute('onchange', elemFile.getAttribute('onchange'));
        clone.setAttribute('accept', elemFile.accept);
        console.log(clone.value);
        elemFile.parentElement.insertBefore(clone, elemFile);
        changeImg(clone.parentElement, getObjURL(clone.files[0]))
        elemFile.remove();
    }

    console.log(detail);
    console.log(elem);
    document.querySelector("#detail").classList.add('d-none');
});
function checkIngredient(value) {
    var container = document.querySelector('#ingredient-container');
    var inputs = container.querySelectorAll('input[name$=name]:not([disabled])');
    for (var i = 0; i < inputs.length; i++) {
        console.log(inputs[i].value.toUpperCase());
        console.log(value.toUpperCase());
        if (inputs[i].value.toUpperCase() === value.toUpperCase())
            return false;
    }
    return true;
}
// stop img that have a camera calling ShowDetail first
$('#inst-container h5, #inst-container .inst-img, #inst-container .inst-img *\n\
    ,#inst-container .item-trashbin, #inst-container .item-trashbin *').click(function (e) {
    e.stopPropagation();
});
// #img-box exit btn
$('#img-box :is(.gray-box, .exit-btn, .cancel-btn)').click(e => {
    document.querySelector("#img-box").classList.add('d-none');
});
// #detail exit btn
$('#detail :is(.gray-box, .exit-btn, .cancel-btn, .save-btn)').click(e => {
    document.querySelector("#detail").classList.add('d-none');
}
);
//------------------------ INGREDIENTS -------------------------------
$('#ingredient [name=iname]').keyup(e => {
    if (e.target.value == "") {
        $('#ingredient-suggestion').addClass('d-none');
    } else {
        $('#ingredient-suggestion').removeClass('d-none');
        $("#ingredient-suggestion span").addClass("d-none");
        $("#ingredient-suggestion span:contains('" + e.target.value + "')").slice(0, 6).removeClass("d-none");
    }
});
$('#ingredient-suggestion span').click(e => {
    $(e.target).text();
    $('#ingredient [name=iname]').val($(e.target).text());
    $('#ingredient [name=iamount]').focus();
    $('#ingredient-suggestion').addClass('d-none');
});
$('#ingredient [name=iamount]').keyup(e => {
    if (e.target.value == "") {
        $('#ingredient-amount-suggestion').addClass('d-none');
    } else {
        var values = e.target.value.split(' ');
        $('#ingredient-amount-suggestion').removeClass('d-none');
        $("#ingredient-amount-suggestion span").addClass("d-none");
        $("#ingredient-amount-suggestion span .p-0").text(values[0]);
        console.log((values[1] || ''));
        $("#ingredient-amount-suggestion span:contains('" + (values[1] || '') + "')").slice(0, 6).removeClass("d-none");
    }
});
$('#ingredient-amount-suggestion span').click(e => {
    $(e.target).html();
    $('#ingredient [name=iamount]').val($(e.target).text());
    $('#ingredient [name=iname]').focus();
    $('#ingredient-amount-suggestion').addClass('d-none');
});















//                             Validator({
//                                 form: '#add-recipe',
//                                 status: '.status',
//                                 rules: [
//                                     Validator.isRequired('[name=recipe-name]'),
//                                         ],
//                                         onSubmit: (value) => {
//                                             //Call api here
//                                             console.log(value);
//                                         },
//                                     });
ItemCopy({
    selector: '#ingredient [name]',
    run: (result, container, step) => {
        if (step) {
            var count = document.querySelector(step);
            count.setAttribute('value', parseInt(count.value) + 1);
        }
        var doc = new DOMParser().parseFromString(result, "text/html");
        var name = doc.querySelector('div input').value;
        console.log(checkIngredient(name));
        if (checkIngredient(name)) {
            $(container).append(result);
        } else
        {
            var error = document.createElement('div');
            error.innerHTML = 'Cannot add same ingredient!';
            $(error).insertAfter($('#ingredient'));
            console.log(error);
            setTimeout(() => error.remove(), 2000);
        }
    },
    count: '#ingredient [name=count]',
    container: '#ingredient-container',
    url: 'ajax/GetIngredientImage',
});
ItemCopy({
    selector: '#instruction [name]',
    run: (result, container, step) => {
        if (step) {
            var count = document.querySelector(step);
            count.setAttribute('value', parseInt(count.value) + 1);
        }
        console.log(result);
        $(container).append(result);
        updateContainer(container);
        $('#inst-container h5, #inst-container .inst-img, #inst-container .inst-img *\n\
                                                ,#inst-container .item-trashbin, #inst-container .item-trashbin *').click(function (e) {
            e.stopPropagation();
        });
    },
    count: '#instruction [name=count]',
    url: 'ajax/GetInstructionTemplate',
    container: '#inst-container',
});