import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../../model/user';
import {Contact} from '../../model/contact';
import {HttpConfigService} from '../httppConfig/http-config.service';

@Injectable({
  providedIn: 'root'
})
export class ContactService {
  constructor(private httpConfig: HttpConfigService) {
  }

  public findAll(): Observable<Contact[]> {
    return this.httpConfig.http.get<Contact[]>('http://localhost:8080/users');
  }

  public delete(id: number) {
    return this.httpConfig.http.delete(this.httpConfig.Url + '/contact/delete/' + id);
  }
}
