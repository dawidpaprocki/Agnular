import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {Contact} from '../../model/contact';
import {HttpConfigService} from '../httppConfig/http-config.service';
import {Patient} from '../../model/patient';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private httpConfig: HttpConfigService) { }

  public findAll(): Observable<Patient[]> {
    return this.httpConfig.http.get<Patient[]>(this.httpConfig.Url + '/patients');
  }
}
