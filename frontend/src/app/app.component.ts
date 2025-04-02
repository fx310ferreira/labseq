import { Component, HostListener } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  template: `
    <div class="container">
      <h1>LabSeq Calculator</h1>
      <div class="input-group">
        <input type="number" [(ngModel)]="index" placeholder="Enter n" (keyup.enter)="getLabSeq()" />
        <button (click)="getLabSeq()">Get LabSeq Value</button>
      </div>
      <p *ngIf="result !== null" class="result">LabSeq({{ index }}) = <strong>{{ result }}</strong></p>
    </div>
  `,
  styleUrls: ['./app.component.css']
})
export class LabseqComponent {
  index: number = 0;
  result: number | null = null;

  constructor(private http: HttpClient) {}

  getLabSeq() {
    if (this.index < 0) return;
    this.http.get<number>(`http://localhost:8080/labseq/${this.index}`)
      .subscribe(response => this.result = response,
                 error => console.error('Error fetching LabSeq value', error));
  }
}