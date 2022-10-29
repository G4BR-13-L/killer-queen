import { Component, OnInit } from '@angular/core';
import { Colaborador } from './colaborador';
import { ColaboradorService } from './colaborador.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent  implements OnInit{
  public colaboradores: Colaborador[] | undefined;

  ngOnInit() {
    this.getColaboradores();
  }
  constructor(private colaboradorService: ColaboradorService) {}

  public getColaboradores(): void{
    this.colaboradorService.getColaboradores().subscribe(
      (response: Colaborador[]) =>{
        this.colaboradores = response;
      },
      ( error: any ) => {
        alert ( error.message )
      }
    );
  }

  public onAddColaborador(addForm: NgForm): void{
    
  }
  public onOpenModal(colaborador: Colaborador, mode: string): void{
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle','modal');
    if( mode == 'add' ){
      button.setAttribute('data-target', '#addColaboradorModal');
    }
    if( mode == 'edit' ){
      button.setAttribute('data-target', '#updateColaboradorModal');
    }
    if( mode == 'delete' ){
      button.setAttribute('data-target', '#deleteColaboradorModal');
    }

    container?.appendChild(button);
    button.click();
  }



}
