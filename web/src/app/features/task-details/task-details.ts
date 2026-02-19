import { Component, inject, Input, OnInit, signal } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { ApiService } from '../../core/services/api.service';
import { Task } from '../../core/models/models';
import { Router } from '@angular/router';

@Component({
  selector: 'app-task-details',
  imports: [
	MatCardModule,
	MatIconModule,
	MatButtonModule
  ],
  templateUrl: './task-details.html',
  styleUrl: './task-details.css',
})
export class TaskDetailsComponent implements OnInit {
	private apiService = inject(ApiService);
	private router = inject(Router);

 	@Input() taskId!: number;

	taskData = signal<Task | null>(null);

	constructor() {}

	ngOnInit(): void {
		console.log('here');
		this.apiService.getTaskById(this.taskId).subscribe({
			next: data => { this.taskData.set(data); console.log(this.taskData) },
			error: () => {}
		});
	}

	goBack() {
		this.router.navigate(["/project", this.taskData()?.projectId]);
	}
}
