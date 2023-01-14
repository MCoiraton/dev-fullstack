import { Inject, Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';
@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authService: AuthService, private router: Router){};
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
      console.log('CanActivate called');
    let isLoggedIn = this.authService.isAuthenticated();
    if (isLoggedIn){
      return true
    } else {
      this.router.navigate(['/login']);
      return false
    }
  }
  isAdmin(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
      console.log('isAdmin called');
    let isAdmin = this.authService.isAuthentificatedAsAdmin();
    if (isAdmin){
      return true
    } else {
      this.router.navigate(['/login']);
      return false
    }
  }
  
  
}
