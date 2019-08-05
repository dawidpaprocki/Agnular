import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user';
import { Observable } from 'rxjs';
import {catchError} from 'rxjs/operators';

@Injectable()
export class UserService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }

  public findAllMap(): Observable<User[]> {
    return this.http.get<User[]>('http://localhost:8080/usersMap');
  }

  public save(user: User) {
    return this.http.post<User>(this.usersUrl, user);
  }
  public delete(id: number) {
    return this.http.delete('http://localhost:8080/delete/' + id);
  }
}
