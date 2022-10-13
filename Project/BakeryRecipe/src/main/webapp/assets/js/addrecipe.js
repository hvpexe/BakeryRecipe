/* global URL */

let formElem = document.getElementById('add-recipe');
let instructionElem = document.getElementById('instruction');
formElem.onsubmit = e => {
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

document.querySelector("#add-video-btn").onclick = () => addVideo('#img-content');
document.querySelector("#add-img-btn").onclick = () => addImage('#img-content');
document.querySelector("#img-content .add-img").onclick = () => addImage('#img-content');


//
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
        name: inputs[0],
        url: inputs[1],
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
    inputs[0].value = option.name.value;
    inputs[1].value = option.url.value;
    inputs[1].oninput = e => {
        var status = e.target.parentElement.querySelector('.status');
        var url = e.target.value;
        status.innerText = "";
        inputs[1].classList.remove('border-danger');
        inputs[1].classList.remove('border-success');
        check = isYoutubeRegex.test(url);
        if (check) {
            inputs[1].classList.add('border-success');
        }
    }
    inputs[1].onblur = e => {
        var status = e.target.parentElement.querySelector('.status');
        var url = e.target.value;
        console.log(e.target.value +" ggggggg");
        check = isYoutubeRegex.test(url);
        if (!check) {
            inputs[1].classList.add('border-danger');
            inputs[1].classList.remove('border-success');
            status.innerText = "Please input Youtube URL";
            console.log("false");
            console.log(check);
            box.querySelector('.save-btn').onclick = () => {};
        } 
        if (check) {
            status.innerText = "";
            inputs[1].classList.remove('border-danger');
            inputs[1].classList.add('border-success');
            console.log("true");
        }
        if (check) {
            // if check == true add a video 
            box.querySelector('.save-btn').onclick = () => {
                option.name.value = inputs[0].value;
                option.url.value = inputs[1].value;
                option.container.classList.remove('d-none');
                option.btn.innerHTML = option.btn.innerHTML.replace('Add', "Update");
                option.video.classList.remove('d-none');
                box.classList.add('d-none');
            };
        } 
        ;
    }

}
// add image 
function addImage(container) {
    var container = document.querySelector(container);
    var span = document.createElement('span');
    var inputPicture = document.createElement('input');
    inputPicture.setAttribute('type', 'file');
    inputPicture.setAttribute('name', 'video-image');
    inputPicture.setAttribute('class', 'd-none');
//    inputPicture.setAttribute('onclick', 'changeImg(this)');
    span.classList = "col-2 p-0 swiper-slide hover-button-2 list-group-item rounded ";
    span.appendChild(inputPicture);
    inputPicture.click();
    container.parentElement.classList.remove("d-none");
    span.onclick = e => {
        console.log(e.target.parentElement);
        container.querySelector('.selected')?.classList.remove('selected');
        e.target.classList.add('selected');
        selectImg(container, e.target, e);
    };
    inputPicture.onchange = e => {
        changeIngrImg(e.target.parentElement, URL.createObjectURL(e.target.files[0]), e);
        swiper.appendSlide(span);
        container.querySelector('.selected')?.classList.remove('selected');
        span.classList.add('selected');
        e.target.onchange = () => changeIngrImg(e.target.parentElement, URL.createObjectURL(e.target.files[0]), e);
    };
}

function selectImg(container, elem, e) {

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
            console.log(inputElement);
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
//removeElem
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
    elem.querySelector('[name=inst-description]').value = detail.querySelector('textarea').value;
    let elemFile = elem.querySelector('[name=inst-image]');
    let detailFile = detail.querySelector('input[type=file]');
    if (detailFile.files[0]) {
        elemFile.files[0] = detailFile.files[0];
        console.log(elemFile.files[0]);
        console.log(detailFile.files[0]);
        let clone = detailFile.cloneNode(true);
        //<input name="inst-image" id="inst-image1" class="d-none" readonly="" type="file" accept="image/*" onchange="changeIngrImg(this.parentElement, window.URL.createObjectURL(this.files[0]), event)">
        clone.setAttribute('name', elemFile.name);
        clone.setAttribute('onchange', elemFile.getAttribute('onchange'));
        clone.setAttribute('accept', elemFile.accept);
        console.log(clone.value);
        elemFile.parentElement.insertBefore(clone, elemFile);
        changeIngrImg(clone.parentElement, window.URL.createObjectURL(clone.files[0]))
        elemFile.remove();
    }


    console.log(detail);
    console.log(elem);
    document.querySelector("#detail").classList.add('d-none');
});
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
});
