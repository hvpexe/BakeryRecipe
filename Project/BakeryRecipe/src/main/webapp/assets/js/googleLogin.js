window.onGoogleLibraryLoad = () => {
    google.accounts.id.initialize({
        client_id: '243057477675-kt58mr9lav8eh6ti9bfrj8p782j7unkd.apps.googleusercontent.com',
        cancel_on_tap_outside: false,
        prompt_parent_id: "root",
        callback: data => handleCredentialResponse(data)
    });
    google.accounts.id.prompt((notification) => {
        if (notification.isNotDisplayed()) {
            console.log(notification.getNotDisplayedReason());
        }
    });

}
function handleCredentialResponse(response) {
    code = parseJwt(response.credential);
    $('#googleLogin').html(
            '<input type="hidden" name="code" value="' + response.credential + '">' +
            '<input type="hidden" name="email" value="' + code['email'] + '">' +
            '<input type="hidden" name="name" value="' + code['name'] + '">' +
            '<input type="hidden" name="avatar" value="' + code['picture'] + '">' +
            '<input type="hidden" name="password" value="">' +
            '<input type="hidden" name="lastname" value="' + code['family_name'] + '">' +
            '<input type="hidden" name="firstname" value="' + code['given_name'] + '">').submit();
    
    console.log(code);
}
function parseJwt(token) {
    var base64Url = token.split('.')[1];
    var base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    var jsonPayload = decodeURIComponent(atob(base64).split('').map(function (c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));

    return JSON.parse(jsonPayload);
}
;
