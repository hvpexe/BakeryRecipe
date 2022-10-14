//i want to make this class to validate every type of form validation 
// yes you can call it a framework

//Validator function
function Validator(options) {
    var selectorRules = {};
    //this function do the validating
    function validate(inputElem, rule) {
        // value: inputElem.value
        // test: rule.test
        var errorElem = inputElem.parentElement.querySelector(options.status);
        var errorMsg;

        //recieve all the rules of the selector
        var rules = selectorRules[rule.selector];

        // run every rule one by one of the selector
        // if errorMsg have value (error) -> exit executing
        for (var i = 0; i < rules.length; i++) {
            errorMsg = rules[i](inputElem.value);
            if (errorMsg)
                break;
        }
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
        return !errorMsg;
    }
    var formElem = document.querySelector(options.form);
    if (formElem) {

        //submitting form
        formElem.onsubmit = e => {
            e.preventDefault();

            var isFormValid = true;

            options.rules.forEach(rule => {
                var inputElem = formElem.querySelector(rule.selector);
                var isValid = validate(inputElem, rule);
                if (!isValid) {
                    isFormValid = false;
                }
            });
            //js submit
            if (isFormValid) {
                console.log('submit success');
                console.log(enableInputs);
                if (typeof options.onSubmit === 'function')
                {
                    var enableInputs = formElem.querySelectorAll('[name]:not([disable])');
                    var formValues = Array.from(enableInputs).reduce((values, input) => {
                        return (values[input.name] = input.value) && values;
                    }, {});
                    options.onSubmit(formValues);
                    formElem.submit();
                }
                //Html Submit
                else {
                    formElem.submit();
                }
            } else {
                console.log('submit false');
            }
        }

        options.rules.forEach(rule => {
            //save all the rules for every input not run yet
            if (Array.isArray(selectorRules[rule.selector])) {
                selectorRules[rule.selector].push(rule.test);
            } else {
                selectorRules[rule.selector] = [rule.test];
            }
            //running
            var inputElem = formElem.querySelector(rule.selector);
            if (inputElem) {
                inputElem.onblur = () => validate(inputElem, rule);
                inputElem.oninput = () => {
                    inputElem.classList.remove('valid');
                    inputElem.classList.remove('invalid');
                }
            }
        });
        //onload
        if (typeof options.onLoad === 'function') {
            options.rules.forEach(rule => {
                var inputElem = formElem.querySelector(rule.selector);
                validate(inputElem, rule);
            });
        }
    } else {
        console.log(options.form + " doesn't exist'");
    }
}

// rules editingqs  
Validator.isRequired = function (selector, msg) {
    return {
        selector: selector,
        test: function (value) {
            return value.trim() ? undefined : msg || 'Please input some text';
        }
    };
};
Validator.isExist = function (selector, msg) {
    return {
        selector: selector,
        test: function (value) {
            return document.querySelector(selector) ? undefined : msg || 'Please Add this Field';
        }
    };
};
Validator.isEmail = function (selector, msg) {
    return {
        selector: selector,
        test: function (value) {
            var regex = /^[a-zA-Z0-9]+(?:\.[a-zA-Z0-9]+)*@[a-zA-Z0-9]+(?:\.[a-zA-Z0-9]+)*$/;
            return regex.test(value) ? undefined : msg || 'Wrong Email Format';
        }
    };
};
Validator.isPassword = function (selector, msg) {
    return {
        selector: selector,
        test: function (value) {
            var regex = /^.{8,40}$/;
            return regex.test(value) ? undefined : msg || 'Password must be between 8 - 40 characters';
        }
    };
};
Validator.isSameValue = function (selector, getConfirmValue, msg) {
    return {
        selector: selector,
        test: function (value) {
            return value === getConfirmValue() ? undefined : msg || 'input field is wrong';
        }
    };
};
