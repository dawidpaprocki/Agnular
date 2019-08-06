import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../../model/user';
import { Observable } from 'rxjs';
import {catchError} from 'rxjs/operators';
import {HttpConfigService} from '../httppConfig/http-config.service';

@Injectable()
export class UserService {
  constructor(private httpConfig: HttpConfigService) {
  }

  public findAll(): Observable<User[]> {

    return this.httpConfig.http.get<User[]>(this.httpConfig.Url + '/users');
  }

  public findAllMap(): Observable<User[]> {
    return this.httpConfig.http.get<User[]>(this.httpConfig.Url + '/users/map');
  }

  public save(user: User) {
    const dwa = this.httpConfig.Url + '/adduser';
    return this.httpConfig.http.post<User>(this.httpConfig.Url + '/adduser', user);
  }
  public delete(id: number) {
    const k = this.httpConfig.Url + '/user/delete/' + id;
    return this.httpConfig.http.delete(k);
  }
}
