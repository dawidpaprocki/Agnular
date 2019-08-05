import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpConfigService {
  private _usersUrl: 'http://localhost:8080/users';
  private _http: HttpClient;

  constructor() {
  }

  get usersUrl(): 'http://localhost:8080/users' {
    return this._usersUrl;
  }

  get http(): HttpClient {
    return this._http;
  }
}
