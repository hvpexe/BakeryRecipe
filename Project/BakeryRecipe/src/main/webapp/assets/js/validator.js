//i want to make this class to validate every type of form validation 
// yes you can call it a framework

//Validator function
function Validator(options) {

    //this function do the validating
    function validate(inputElem, rule) {
        // value: inputElem.value
        // test: rule.test
        var errorMsg = rule.test(inputElem.value);
        var errorElem = inputElem.parentElement.querySelector(options.status);

        // if test = false run status will appear
        if (errorMsg) {
            errorElem.innerText = errorMsg;
            inputElem.classList.remove('valid');
            inputElem.classList.add('invalid');
        } else {
            errorElem.innerText = '';
            inputElem.classList.add('valid');
            inputElem.classList.remove('invalid');
        }

    }

    var form = document.querySelector(options.form);
    if (form) {
        options.rules.forEach(rule => {
            var inputElem = form.querySelector(rule.selector);
            if (inputElem) {
                inputElem.onblur = () => validate(inputElem, rule);
                inputElem.oninput = () => {
                    errorElem.innerText = '';
                    inputElem.classList.add('valid');
                    inputElem.classList.remove('invalid');
                }
            }
        });
    } else {
        console.log(selector + " doesn't exist'");
    }
}

// rules editingqs  
Validator.isRequired = function (selector) {
    return {
        selector: selector,
        test: function (value) {
            return value.trim() ? undefined : 'Please input some text';
        }
    };
}
Validator.isEmail = function (selector) {
    return {
        selector: selector,
        test: function (value) {
            var regex = /^[a-zA-Z0-9]+(?:\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\.[a-zA-Z0-9]+)*$/;
            return regex.test(value) ? undefined : 'Wrong Email Format';
        }
    };
}
Validator.isPassword = function (selector) {
    return {
        selector: selector,
        test: function (value) {
            var regex = /^.{8,40}$/;
            return regex.test(value) ? undefined : 'Password must be between 8 - 40 characters';
        }
    };
}