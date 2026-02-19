import { Component, inject, Input, OnInit, signal } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { ApiService } from '../../core/services/api.service';
import { Issue } from '../../core/models/models';
import { Router } from '@angular/router';

@Component({
  selector: 'app-issue-details',
  imports: [
	MatCardModule,
	MatIconModule,
	MatButtonModule
  ],
  templateUrl: './issue-details.html',
  styleUrl: './issue-details.css',
})
export class IssueDetailsComponent implements OnInit {
	private apiService = inject(ApiService);
	private router = inject(Router);

 	@Input() issueId!: number;

	issueData = signal<Issue | null>(null);

	constructor() {}

	ngOnInit(): void {
		this.apiService.getIssueById(this.issueId).subscribe({
			next: data => { this.issueData.set(data) },
			error: () => {}
		});
	}

	goBack() {
		this.router.navigate(["/project", this.issueData()?.projectId]);
	}
}
