import { Component, OnInit, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.html',
  styleUrl: './usuarios.css',
})
export class Usuarios implements OnInit, OnDestroy {
  ngOnInit() {
    document.body.classList.add('usuarios');
  }

  ngOnDestroy() {
    document.body.classList.remove('usuarios');
  }
}
