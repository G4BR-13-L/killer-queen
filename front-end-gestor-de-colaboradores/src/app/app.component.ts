import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Colaborador } from './colaborador';
import { ColaboradorService } from './colaborador.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  public colaboradores!: Colaborador[];
  public editColaborador!: Colaborador;
  public deleteColaborador!: Colaborador;

  public genericColaborador: Colaborador = {
    id: 3,
    nome: "Fulano",
    email: "email@email.com",
    cargo: "Cargo",
    telefone: "9955640843",
    imgUrl: '',
    codigoColaborador: "1234",
  }
  ngOnInit() {
    this.colaboradorService.addColaborador(this.genericColaborador)
    this.getColaboradores();
  }
  constructor(private colaboradorService: ColaboradorService) { }

  public getColaboradores(): void {
    this.colaboradorService.getColaboradores().subscribe(
      (response: Colaborador[]) => {
        this.colaboradores = response;
      },
      (error: any) => {
        alert(error.message)
      }
    );
  }

  public onAddColaborador(addForm: NgForm): void {
    document.getElementById('add-colaborador-form')?.click();

    this.colaboradorService.addColaborador(addForm.value).subscribe(
      (response: Colaborador) => {
        console.log(response);
        this.getColaboradores();
        addForm.reset();
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
        addForm.reset();

      }
    )
  }

  public onUpdateColaborador(colaborador: Colaborador): void {
    this.colaboradorService.updateColaborador(colaborador).subscribe(
      (response: Colaborador) => {
        console.log(response);
        this.getColaboradores();
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    )
  }

  public onDeleteColaborador(colaboradorId: number): void {
    this.colaboradorService.deleteColaborador(colaboradorId).subscribe(
      (response: void) => {
        console.log(response);
        this.getColaboradores();
      },
      (error: HttpErrorResponse) => {
        alert(error.message)
      }
    )
  }




  public onOpenModal(colaborador: Colaborador | null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode == 'add') {
      button.setAttribute('data-target', '#addColaboradorModal');
    }
    if (mode == 'edit') {
      this.editColaborador = colaborador as Colaborador;
      button.setAttribute('data-target', '#updateColaboradorModal');
    }
    if (mode == 'delete') {
      this.deleteColaborador = colaborador as Colaborador;
      button.setAttribute('data-target', '#deleteColaboradorModal');
    }

    container?.appendChild(button);
    button.click();
  }



}
