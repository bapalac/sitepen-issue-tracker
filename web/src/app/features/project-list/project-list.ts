import { Component, inject, OnInit, signal } from '@angular/core';
import { ApiService } from '../../core/services/api.service';
import { Project } from '../../core/models/models';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { Router } from '@angular/router';

@Component({
  selector: 'app-project-list',
  imports: [
	CommonModule,
    MatCardModule,
    MatIconModule,
    MatButtonModule
  ],
  templateUrl: './project-list.html',
  styleUrl: './project-list.css',
})
export class ProjectListComponent implements OnInit{
	private apiService = inject(ApiService);
	private router = inject(Router);

	projectList = signal<Project[]>([]);

	constructor() {}

	ngOnInit(): void {
		this.apiService.getAllProjects().subscribe({
			next: data => { this.projectList.set(data); },
			error: () => {}
		});
	}

	navigateToProjectDetails(projectId: number) {
		this.router.navigate(["/project", projectId]);
	}

}
