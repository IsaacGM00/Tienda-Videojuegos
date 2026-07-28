import { AfterViewInit, Component } from '@angular/core';

@Component({
  selector: 'app-carrusel',
  imports: [],
  templateUrl: './carrusel.html',
  styleUrl: './carrusel.css',
})
export class Carrusel implements AfterViewInit{
  ngAfterViewInit(): void {
    let counter = 1;

    setInterval(() => {
      // Verificamos que estamos en navegador
      if (typeof document !== 'undefined') {
        const radio = document.getElementById('radio' + counter) as HTMLInputElement;
        if (radio) {
          radio.checked = true;
        }
      }

      counter++;
      if (counter > 3) {
        counter = 1;
      }
    }, 5000);
  }
}
