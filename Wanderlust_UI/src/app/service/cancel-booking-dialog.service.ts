import { Injectable } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CancelBookingDialogComponent } from '../cancel-booking-dialog/cancel-booking-dialog.component';

@Injectable()
export class CancelBookingDialogService {

  constructor(private modalService: NgbModal) { }

  public confirm (title: string, message: string, btnOkText: string = 'Confirm Cancellation', btnCancelText: string = 'Back'): Promise<boolean> {
    const modalRef = this.modalService.open(CancelBookingDialogComponent);
    modalRef.componentInstance.title = title;
    modalRef.componentInstance.message = message;
    modalRef.componentInstance.btnOkText = btnOkText;
    modalRef.componentInstance.btnCancelText = btnCancelText;
    return modalRef.result;
  }
}
