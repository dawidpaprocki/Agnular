import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class HttpConfigService {
  private _Url = 'http://localhost:8080';
  private _http;

  constructor(private htttpClient: HttpClient) {
    this._http = htttpClient;
  }

  get Url(): string {
    return this._Url;
  }

  get http() {
    return this._http;
  }
}
