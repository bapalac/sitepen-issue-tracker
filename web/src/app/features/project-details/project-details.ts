import { Component, CUSTOM_ELEMENTS_SCHEMA, inject, Input, OnInit, signal } from '@angular/core';
import { ApiService } from '../../core/services/api.service';
import { Task } from '../../core/models/models';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { Router } from '@angular/router';
import { TaskListComponent } from '../task-list/task-list';

@Component({
  selector: 'app-project-details',
  imports: [
	CommonModule,
    MatCardModule,
    MatIconModule,
    MatButtonModule,
	TaskListComponent
  ],
  schemas: [
	CUSTOM_ELEMENTS_SCHEMA
  ],
  templateUrl: './project-details.html',
  styleUrl: './project-details.css',
})
export class ProjectDetailsComponent implements OnInit{
	private apiService = inject(ApiService);
	private router = inject(Router);

 	@Input() projectId!: number;

	taskList = signal<Task[] | null>(null);

	constructor() {}

	ngOnInit(): void {
		console.log(this.projectId);
		this.apiService.getAllTasksByProjectId(this.projectId).subscribe({
			next: data => { this.taskList.set(data) },
			error: () => {}
		});
	}

	navigateToTaskDetails(taskId: number) {
		this.router.navigate(["/task", taskId]);
	}
}
