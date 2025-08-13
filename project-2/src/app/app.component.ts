import { Component } from "@angular/core";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"],
})
export class AppComponent {
  title = "Angular Docker Application";

  features = [
    "Built with Angular CLI",
    "Containerized with Docker",
    "Multi-stage Docker build",
    "Development and Production environments",
    "Docker Compose configuration",
    "Nginx for production serving",
  ];

  currentTime = new Date();

  constructor() {
    // Update time every second
    setInterval(() => {
      this.currentTime = new Date();
    }, 1000);
  }
}
