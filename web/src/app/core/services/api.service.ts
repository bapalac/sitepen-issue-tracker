import { inject, Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';
import { Project, Issue } from '../models/models';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
	private http = inject(HttpClient);
  private readonly BASE_URL = `${environment.apiUrl}`;

  private jsonHeaders = new HttpHeaders({
    'Content-Type': 'application/json'
  });

  constructor() {}

  getAllIssues(): Observable<Issue[]> {
	return this.http.get<Issue[]>(`${this.BASE_URL}/issues/get-all`);
  }

  getIssueById(issueId: number): Observable<Issue> {
	return this.http.get<Issue>(`${this.BASE_URL}/issues/${issueId}`);
  }

  getAllIssuesByProjectId(projectId: number): Observable<Issue[]> {
	return this.http.get<Issue[]>(`${this.BASE_URL}/issues/get-all-by-project/${projectId}`);
  }

  getAllProjects(): Observable<Project[]> {
	return this.http.get<Project[]>(`${this.BASE_URL}/projects/get-all`);
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
  // Generic DELETE
  // -----------------------------
  delete<T>(endpoint: string): Observable<T> {
    return this.http.delete<T>(`${this.BASE_URL}/${endpoint}`);
  }
}