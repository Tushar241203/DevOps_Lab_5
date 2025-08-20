import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  template: `
    <h1>Welcome to Angular Docker App</h1>
    <p>This Angular application is running in a Docker container!</p>
    <router-outlet></router-outlet>
  `,
  styles: [`
    h1 { color: #1976d2; }
    p { font-size: 18px; }
  `]
})
export class AppComponent {
  title = 'angular-docker-app';
}
