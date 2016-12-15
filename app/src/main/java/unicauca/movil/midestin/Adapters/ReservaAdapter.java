package unicauca.movil.midestin.Adapters;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import unicauca.movil.midestin.R;
import unicauca.movil.midestin.databinding.TemplateReservaBinding;
import unicauca.movil.midestin.util.L;

/**
 * Created by Kathe on 14/12/2016.
 */

public class ReservaAdapter extends RecyclerView.Adapter<ReservaAdapter.ReservaViewHolder>{

    public interface OnReservaListener{
        void onReserva(View v);
    }
    LayoutInflater inflater;

    ReservaAdapter.OnReservaListener onReservaListener;

    public ReservaAdapter(LayoutInflater inflater, ReservaAdapter.OnReservaListener onReservaListener){
        this.onReservaListener= onReservaListener;
        this.inflater= inflater;
    }

    @Override
    public ReservaAdapter.ReservaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.template_reserva,parent,false);
        ReservaAdapter.ReservaViewHolder holder = new ReservaAdapter.ReservaViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ReservaAdapter.ReservaViewHolder holder, int position) {
        holder.binding.setTiq(L.data.get(position));
        holder.binding.setHandlerreserva(this);
    }

    @Override
    public int getItemCount() {

        return L.data.size();
    }

    public void onClickReserva (View v){
        onReservaListener.onReserva(v);

    }


//Retorna tipo de variable o celda
 /*   @Override
    public int getItemViewType(int position) {
        return 0;
    }

    */

    public  static class ReservaViewHolder extends RecyclerView.ViewHolder{
        TemplateReservaBinding binding;

        public ReservaViewHolder(View itemView) {
            super(itemView);

            binding= DataBindingUtil.bind(itemView);

        }
    }
}

