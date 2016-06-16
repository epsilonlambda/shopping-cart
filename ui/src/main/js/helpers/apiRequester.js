import $ from 'jquery';
import cookieDough from 'cookie-dough';

export function getToken() {
        var cookie = cookieDough();
        return cookie.get('jwt');
}

export function apiRequest({path, method, body, success, fail, authenticate}) {
    $.ajax({
        method,
        processData: false,
        data: body !== undefined ? JSON.stringify(body) : undefined,
        contentType: 'application/json',
        url: /*'http://localhost:8080' +*/ path,
        headers: authenticate ? { 'Authorization': 'Bearer ' + getToken() } : undefined
    }).done(success).fail(fail);
}

export function tokenRequest({path, method, success, fail}) {
    $.ajax({
        method,
        url: /* 'http://localhost:8080'  +*/ path
    }).done((data) => {
        var cookie = cookieDough();
        cookie.set('jwt', data, { maxAge: 31536e3 });
        success();
    }).fail(fail);
}