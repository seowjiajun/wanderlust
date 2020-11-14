import { Injectable } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CancelBookingErrorDialogComponent } from '../cancel-booking-error-dialog/cancel-booking-error-dialog.component';

@Injectable()
export class CancelBookingErrorDialogService {

  constructor(private modalService: NgbModal) { }

  public alert(title: string, message: string, btnOkText: string = 'OK'): Promise<boolean> {
    const modalRef = this.modalService.open(CancelBookingErrorDialogComponent);
    modalRef.componentInstance.title = title;
    modalRef.componentInstance.message = message;
    modalRef.componentInstance.btnOkText = btnOkText;
    return modalRef.result;
  }
}
