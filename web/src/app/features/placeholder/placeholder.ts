import { Component, OnInit, signal } from '@angular/core';
import { ApiService } from '../../core/services/api.service';
import { PlaceholderData } from '../../core/models/models';

@Component({
  selector: 'app-placeholder',
  standalone: true,
  imports: [],
  templateUrl: './placeholder.html',
  styleUrl: './placeholder.css',
})
export class PlaceholderComponent implements OnInit {
	placeholderData = signal<PlaceholderData | null>(null);

	constructor(private apiService: ApiService) {}

	ngOnInit(): void {
		this.apiService.getbyId(1).subscribe({
			next: data => { this.placeholderData.set(data) },
			error: () => {}
		});
	}

}
