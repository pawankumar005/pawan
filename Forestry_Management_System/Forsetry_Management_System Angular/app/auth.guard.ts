
import { CanActivate, ActivatedRouteSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';
@Injectable({
    providedIn: 'root'
})
export class AuthGuard implements CanActivate {

    canActivate(route: ActivatedRouteSnapshot): boolean {
        let expectedRolesArray = route.data.expectedRoles;
        let userDetails = JSON.parse(localStorage.getItem('userDetails'))
        let expectedRole: string;
        for (let index in expectedRolesArray) {
            if (userDetails && userDetails.loginBeans[0].role === expectedRolesArray[index]) {
                expectedRole = expectedRolesArray[index];
            }
        }
        if (userDetails && userDetails.loginBeans[0].role) {
            return true;

        } else {
            return false;
        }
    }

}