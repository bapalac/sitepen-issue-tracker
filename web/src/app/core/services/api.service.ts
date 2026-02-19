import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import { PlaceholderData, Task } from '../models/models';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private readonly BASE_URL = `${environment.apiUrl}`;

  private jsonHeaders = new HttpHeaders({
    'Content-Type': 'application/json'
  });

  constructor(private http: HttpClient) {}

  getbyId(id: number): Observable<PlaceholderData> {
	return this.http.get<PlaceholderData>(`${this.BASE_URL}/${id}`);
  }

  getAllTasks(): Observable<Array<Task>> {
	return this.http.get<Array<Task>>(`${this.BASE_URL}/tasks/get-all`);
  }

  // -----------------------------
  // Generic GET
  // -----------------------------
  get<T>(endpoint: string): Observable<T> {
    return this.http.get<T>(`${this.BASE_URL}/${endpoint}`);
  }

  // -----------------------------
  // Generic POST
  // -----------------------------
  post<T>(endpoint: string, body: any): Observable<T> {
    return this.http.post<T>(`${this.BASE_URL}/${endpoint}`, body, {
      headers: this.jsonHeaders
    });
  }

  // -----------------------------
  // Generic PUT
  // -----------------------------
  put<T>(endpoint: string, body: any): Observable<T> {
    return this.http.put<T>(`${this.BASE_URL}/${endpoint}`, body, {
      headers: this.jsonHeaders
    });
  }

  // -----------------------------
  // Generic PATCH
  // -----------------------------
  patch<T>(endpoint: string, body: any): Observable<T> {
    return this.http.patch<T>(`${this.BASE_URL}/${endpoint}`, body, {
      headers: this.jsonHeaders
    });
  }

  // -----------------------------
  // Generic DELETE
  // -----------------------------
  delete<T>(endpoint: string): Observable<T> {
    return this.http.delete<T>(`${this.BASE_URL}/${endpoint}`);
  }
}