import { Injectable } from '@angular/core';
import {HttpConfigService} from '../httppConfig/http-config.service';
import {Observable} from 'rxjs';
import {Contact} from '../../model/contact';
import {ContactReason} from '../../model/contactReason';

@Injectable({
  providedIn: 'root'
})
export class ContactReasonService {

  constructor(private httpConfig: HttpConfigService) {
  }
  public findAll(): Observable<ContactReason[]> {
    return this.httpConfig.http.get<ContactReason[]>(this.httpConfig.Url + '/contactsReason');
  }

  public save(contactReason: ContactReason) {
    return this.httpConfig.http.post<ContactReason>(this.httpConfig.Url + '/addContactReason', contactReason);
  }

  public delete(id: number) {
    return this.httpConfig.http.delete(this.httpConfig.Url + '/contactReason/delete/' + id);
  }
}
