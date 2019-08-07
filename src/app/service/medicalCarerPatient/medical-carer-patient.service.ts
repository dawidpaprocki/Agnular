import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {User} from '../../model/user';
import {HttpConfigService} from '../httppConfig/http-config.service';

@Injectable({
  providedIn: 'root'
})
export class MedicalCarerPatientService {

  constructor(private httpConfig: HttpConfigService) {
  }

  public findAll(): Observable<User[]> {

    return this.httpConfig.http.get<User[]>(this.httpConfig.Url + '/MedicalCarerPatient');
  }

  public findAllMap(): Observable<User[]> {
    return this.httpConfig.http.get<User[]>(this.httpConfig.Url + '/MedicalCarerPatient/map');
  }

  public save(user: User) {
    return this.httpConfig.http.post<User>(this.httpConfig.Url + '/MedicalCarerPatient', user);
  }

  public delete(id: number) {
    return this.httpConfig.http.delete('/MedicalCarerPatient/delete/' + id);
  }
}
