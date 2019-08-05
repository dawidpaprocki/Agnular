import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Contact} from '../../model/contact';
import {HttpConfigService} from '../httppConfig/http-config.service';

@Injectable({
  providedIn: 'root'
})
export class ContactService {
  constructor(private httpConfig: HttpConfigService) {
  }

  public findAll(): Observable<Contact[]> {
    return this.httpConfig.http.get<Contact[]>(this.httpConfig.Url + '/contacts');
  }

  public save(contact: Contact) {
    return this.httpConfig.http.post<Contact>(this.httpConfig.Url, contact);
  }

  public delete(id: number) {
    return this.httpConfig.http.delete(this.httpConfig.Url + '/contact/delete/' + id);
  }

}
