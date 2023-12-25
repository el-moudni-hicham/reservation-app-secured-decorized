import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReservationComponent } from './reservation/reservation.component';
import { ReservatorComponent } from './reservator/reservator.component';
import { ResourceComponent } from './resource/resource.component';
import { AuthGuard } from './guards/auth-guard.guard';

const routes: Routes = [
  { path: 'reservation', component: ReservationComponent, canActivate : [AuthGuard], data : {roles:['ADMIN']}},
  { path: 'reservator', component: ReservatorComponent, canActivate : [AuthGuard], data : {roles:['ADMIN']}},
  { path: 'resource', component: ResourceComponent, canActivate : [AuthGuard], data : {roles:['ADMIN']}},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
