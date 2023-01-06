package com.stackdining.www.squareup;

import androidx.annotation.NonNull;

import java.io.IOException;

import sqip.CardDetails;
import sqip.CardEntryActivityCommand;
import sqip.CardNonceBackgroundHandler;

public class CardEntryBackgroundHandler implements CardNonceBackgroundHandler {

    @NonNull
    @Override
    public CardEntryActivityCommand handleEnteredCardInBackground(@NonNull CardDetails cardDetails) {
        try {
            // TODO Call your backend service
//            MyBackendServiceResponse response = // myBackendService(cardDetails.getNonce());...
//            if (response.isSuccessful()) {
//                return new CardEntryActivityCommand.Finish();
//            } else {
//                return new CardEntryActivityCommand.ShowError(response.errorMessage)
//            }
        } catch(Exception exception) {
//            return new CardEntryActivityCommand.ShowError(
//                    resources.getString(R.string.network_failure));
        }
        return null;
    }
}
